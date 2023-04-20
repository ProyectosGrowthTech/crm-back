package org.crm.crmback.infrastructure.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.infrastructure.configuration.model.Secrets;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(Secrets.class)
public class SecretsConfiguration {

  private final Secrets secrets;
}
