package org.crm.crmback.application.v1.service.authentication;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.security.AccessToken;
import org.crm.crmback.domain.model.security.LoginTokens;
import org.crm.crmback.domain.model.security.RefreshToken;
import org.crm.crmback.infrastructure.configuration.model.Secrets;
import org.crm.crmback.infrastructure.redis.facade.TokenPersistenceFacade;
import org.crm.crmback.infrastructure.token.TokenGenerator;
import org.crm.crmback.infrastructure.token.charset.DefaultTokenCharset;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshServiceImpl implements RefreshService {

  private final Secrets secrets;

  private final TokenPersistenceFacade tokenPersistenceFacade;

  private final TokenGenerator tokenGenerator;

  @Override
  public LoginTokens refreshToken(String refreshToken) {
    RefreshToken foundRefreshToken = tokenPersistenceFacade.getRefreshTokenById(refreshToken);
    String accessTokenString =
        tokenGenerator.generate(
            DefaultTokenCharset.ALL_CHARACTERS, secrets.token().accessToken().length());
    AccessToken accessToken =
        new AccessToken(
            accessTokenString,
            secrets.token().accessToken().lifetime(),
            foundRefreshToken,
            foundRefreshToken.identityToken());
    tokenPersistenceFacade.saveAccessToken(accessToken);
    return new LoginTokens(
        accessTokenString, foundRefreshToken.token(), foundRefreshToken.sessionToken().token());
  }
}
