package org.crm.crmback.infrastructure.configuration;

import java.time.Duration;
import java.util.Objects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

  @Bean
  public RedisConnectionFactory connectionFactory(Environment env) {
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
    configuration.setDatabase(
        Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.redis.database"))));
    configuration.setHostName(Objects.requireNonNull(env.getProperty("spring.redis.host")));
    configuration.setPort(
        Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.redis.port"))));
    JedisClientConfiguration clientConfiguration =
        JedisClientConfiguration.builder()
            .readTimeout(Duration.ofMillis(5000))
            .connectTimeout(
                Duration.ofMillis(
                    Long.parseLong(
                        Objects.requireNonNull(env.getProperty("spring.redis.connect-timeout")))))
            .usePooling()
            .build();
    return new JedisConnectionFactory(configuration, clientConfiguration);
  }

  @Bean("redisRepositoriesTemplate")
  public RedisTemplate<?, ?> redisRepositoriesTemplate(
      RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    template.setEnableTransactionSupport(true);
    return template;
  }
}
