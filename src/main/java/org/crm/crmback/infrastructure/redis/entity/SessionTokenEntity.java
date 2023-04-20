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
@RedisHash("sessionToken")
@AllArgsConstructor
@NoArgsConstructor
public class SessionTokenEntity {

  @Id private String sessionToken;

  private String identityToken;

  // ToDo: Add things like IP, Geoloc, etc

  @TimeToLive(unit = TimeUnit.MILLISECONDS)
  private Long ttl;
}
