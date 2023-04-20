package org.crm.crmback.infrastructure.configuration.model;

import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("application")
public record Secrets(
    @NotNull HashConfig hash,
    @NotNull JwtConfig jwt,
    @NotNull TokenConfig token,
    @NotNull SecurityConfig security) {}
