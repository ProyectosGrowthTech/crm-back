package org.crm.crmback.infrastructure.redis.entity;

import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Setter
@RedisHash("accessToken")
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenEntity {

  @Id private String accessToken;

  private String refreshToken;

  private String identityToken;

  @TimeToLive(unit = TimeUnit.MILLISECONDS)
  private Long ttl;
}
