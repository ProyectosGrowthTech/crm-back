package org.crm.crmback.infrastructure.redis.mapper;

import java.time.Duration;
import org.crm.crmback.domain.model.security.AccessToken;
import org.crm.crmback.domain.model.security.IdentityToken;
import org.crm.crmback.domain.model.security.RefreshToken;
import org.crm.crmback.domain.model.security.SessionToken;
import org.crm.crmback.infrastructure.redis.entity.AccessTokenEntity;
import org.crm.crmback.infrastructure.redis.entity.RefreshTokenEntity;
import org.crm.crmback.infrastructure.redis.entity.SessionTokenEntity;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {

  public AccessTokenEntity tokenToAccessTokenEntity(AccessToken token) {
    return new AccessTokenEntity(
        token.token(),
        token.refreshToken().token(),
        token.identityToken().token(),
        token.lifetime().toMillis());
  }

  public RefreshTokenEntity tokenToRefreshTokenEntity(RefreshToken token) {
    return new RefreshTokenEntity(
        token.token(),
        token.sessionToken().token(),
        token.identityToken().token(),
        token.lifetime().toMillis());
  }

  public SessionTokenEntity tokenToSessionTokenEntity(SessionToken token) {
    return new SessionTokenEntity(
        token.token(), token.identityToken().token(), token.lifetime().toMillis());
  }

  public RefreshToken refreshTokenEntityToToken(RefreshTokenEntity foundRefreshToken) {
    IdentityToken identityToken =
        new IdentityToken(
            foundRefreshToken.getIdentityToken(), Duration.ofMillis(foundRefreshToken.getTtl()));
    SessionToken sessionToken =
        new SessionToken(
            foundRefreshToken.getSessionToken(),
            Duration.ofMillis(foundRefreshToken.getTtl()),
            identityToken);
    return new RefreshToken(
        foundRefreshToken.getRefreshToken(),
        Duration.ofMillis(foundRefreshToken.getTtl()),
        sessionToken,
        identityToken);
  }
}
