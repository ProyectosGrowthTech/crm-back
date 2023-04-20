package org.crm.crmback.domain.service.authentication;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.exception.PasswordDoesNotMatchException;
import org.crm.crmback.domain.model.security.*;
import org.crm.crmback.infrastructure.configuration.model.Secrets;
import org.crm.crmback.infrastructure.hash.HashFacade;
import org.crm.crmback.infrastructure.jwt.JwtFacade;
import org.crm.crmback.infrastructure.rdbms.facade.UserPersistenceFacade;
import org.crm.crmback.infrastructure.redis.facade.TokenPersistenceFacade;
import org.crm.crmback.infrastructure.token.TokenGenerator;
import org.crm.crmback.infrastructure.token.charset.DefaultTokenCharset;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

  private final Secrets secrets;

  private final UserPersistenceFacade userPersistenceFacade;

  private final TokenPersistenceFacade tokenPersistenceFacade;

  private final TokenGenerator tokenGenerator;

  private final JwtFacade jwtFacade;

  private final HashFacade hashFacade;

  @Override
  public LoginTokens login(Credentials credentials) {
    User user = userPersistenceFacade.findByUsername(credentials.username());
    if (!hashFacade.check(user.getPassword(), credentials.plainTextPassword())) {
      throw new PasswordDoesNotMatchException(
          "provided password and stored password does not match");
    }
    AuthenticationTokens tokensToPersist = this.generateTokens(user.serializeClaims());
    tokenPersistenceFacade.save(tokensToPersist);
    return new LoginTokens(
        tokensToPersist.accessToken().token(),
        tokensToPersist.refreshToken().token(),
        tokensToPersist.sessionToken().token());
  }

  private AuthenticationTokens generateTokens(Map<String, Object> claims) {
    String accessTokenString =
        tokenGenerator.generate(
            DefaultTokenCharset.ALL_CHARACTERS, secrets.token().accessToken().length());
    String refreshTokenString =
        tokenGenerator.generate(
            DefaultTokenCharset.ALL_CHARACTERS, secrets.token().refreshToken().length());
    String sessionTokenString =
        tokenGenerator.generate(
            DefaultTokenCharset.ALL_CHARACTERS, secrets.token().refreshToken().length());
    String identityTokenString = jwtFacade.generate(claims);
    IdentityToken identityToken =
        new IdentityToken(identityTokenString, secrets.token().refreshToken().lifetime());
    SessionToken sessionToken =
        new SessionToken(
            sessionTokenString, secrets.token().refreshToken().lifetime(), identityToken);
    RefreshToken refreshToken =
        new RefreshToken(
            refreshTokenString,
            secrets.token().refreshToken().lifetime(),
            sessionToken,
            identityToken);
    AccessToken accessToken =
        new AccessToken(
            accessTokenString,
            secrets.token().accessToken().lifetime(),
            refreshToken,
            identityToken);
    return new AuthenticationTokens(accessToken, refreshToken, sessionToken, identityToken);
  }
}
