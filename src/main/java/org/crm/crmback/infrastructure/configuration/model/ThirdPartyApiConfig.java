package org.crm.crmback.infrastructure.configuration.model;

import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
public record ThirdPartyApiConfig(@NotNull PokemonTcgApiConfig pokemonTcg) {}
