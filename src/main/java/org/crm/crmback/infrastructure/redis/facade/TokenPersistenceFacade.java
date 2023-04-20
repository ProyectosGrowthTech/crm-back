package org.crm.crmback.infrastructure.redis.facade;

import org.crm.crmback.domain.model.security.AccessToken;
import org.crm.crmback.domain.model.security.AuthenticationTokens;
import org.crm.crmback.domain.model.security.RefreshToken;

public interface TokenPersistenceFacade {

  void save(AuthenticationTokens tokens);

  String getIdentityTokenByAccessToken(String accessToken);

  RefreshToken getRefreshTokenById(String refreshToken);

  void saveAccessToken(AccessToken accessToken);
}
