package org.crm.crmback.infrastructure.redis.facade;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.security.AccessToken;
import org.crm.crmback.domain.model.security.AuthenticationTokens;
import org.crm.crmback.domain.model.security.RefreshToken;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.crm.crmback.infrastructure.redis.entity.AccessTokenEntity;
import org.crm.crmback.infrastructure.redis.entity.RefreshTokenEntity;
import org.crm.crmback.infrastructure.redis.mapper.TokenMapper;
import org.crm.crmback.infrastructure.redis.repository.AccessTokenRepository;
import org.crm.crmback.infrastructure.redis.repository.RefreshTokenRepository;
import org.crm.crmback.infrastructure.redis.repository.SessionTokenRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenPersistenceFacadeImpl implements TokenPersistenceFacade {

  private final AccessTokenRepository accessTokenRepository;

  private final RefreshTokenRepository refreshTokenRepository;

  private final SessionTokenRepository sessionTokenRepository;

  private final TokenMapper mapper;

  @Transactional
  @Override
  public void save(AuthenticationTokens tokens) {
    accessTokenRepository.save(mapper.tokenToAccessTokenEntity(tokens.accessToken()));
    refreshTokenRepository.save(mapper.tokenToRefreshTokenEntity(tokens.refreshToken()));
    sessionTokenRepository.save(mapper.tokenToSessionTokenEntity(tokens.sessionToken()));
  }

  @Override
  public String getIdentityTokenByAccessToken(String accessToken) {
    AccessTokenEntity foundAccessToken =
        accessTokenRepository
            .findById(accessToken)
            .orElseThrow(() -> new ItemNotFoundException("access token not found"));
    return foundAccessToken.getIdentityToken();
  }

  @Override
  public RefreshToken getRefreshTokenById(String refreshToken) {
    RefreshTokenEntity foundRefreshToken =
        refreshTokenRepository
            .findById(refreshToken)
            .orElseThrow(() -> new ItemNotFoundException("refresh token not found"));
    return mapper.refreshTokenEntityToToken(foundRefreshToken);
  }

  @Override
  public void saveAccessToken(AccessToken accessToken) {
    accessTokenRepository.save(mapper.tokenToAccessTokenEntity(accessToken));
  }
}
