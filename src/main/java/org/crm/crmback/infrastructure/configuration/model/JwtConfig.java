package org.crm.crmback.infrastructure.configuration.model;

import javax.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
public record JwtConfig(@NotBlank String publicKey, @NotBlank String privateKey) {}
