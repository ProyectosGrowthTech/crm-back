package org.crm.crmback.infrastructure.configuration.model;

import javax.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
public record PokemonTcgApiConfig(@NotBlank String apiKey, @NotBlank String baseUrl) {}
