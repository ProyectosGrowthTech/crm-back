package org.crm.crmback.infrastructure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.infrastructure.configuration.model.Secrets;
import org.crm.crmback.infrastructure.hash.BcryptHashFacade;
import org.crm.crmback.infrastructure.hash.HashFacade;
import org.crm.crmback.infrastructure.jwt.JwtFacade;
import org.crm.crmback.infrastructure.jwt.JwtRsa512Facade;
import org.crm.crmback.infrastructure.keyparser.RsaKeyParser;
import org.crm.crmback.infrastructure.redis.facade.TokenPersistenceFacade;
import org.crm.crmback.infrastructure.security.AuthenticationFilter;
import org.crm.crmback.infrastructure.security.AuthorizationInterceptor;
import org.crm.crmback.infrastructure.security.model.RequestSecurityContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration implements WebMvcConfigurer {

  private final AuthorizationInterceptor authorizationInterceptor;

  @Bean
  public JwtFacade jwtFacade(Secrets secrets, RsaKeyParser rsaKeyParser) {
    RSAPublicKey publicKey = rsaKeyParser.parsePublicKey(secrets.jwt().publicKey());
    RSAPrivateKey privateKey = rsaKeyParser.parsePrivateKey(secrets.jwt().privateKey());
    return new JwtRsa512Facade(publicKey, privateKey);
  }

  @Bean
  public HashFacade hashFacade(Secrets secrets) {
    return new BcryptHashFacade(secrets.hash().logRounds());
  }

  @Bean
  public SecureRandom secureRandom() {
    return new SecureRandom();
  }

  @Bean
  public AuthenticationFilter authenticationFilter(
      Secrets secrets,
      JwtFacade jwtFacade,
      TokenPersistenceFacade tokenPersistenceFacade,
      ObjectMapper objectMapper,
      RequestSecurityContextHolder requestSecurityContextHolder) {
    return new AuthenticationFilter(
        secrets, jwtFacade, tokenPersistenceFacade, objectMapper, requestSecurityContextHolder);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authorizationInterceptor);
  }
}
