package org.crm.crmback.infrastructure.configuration.model;

import java.time.Duration;
import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
public record SpecificTokenConfig(@NotNull Integer length, @NotNull Duration lifetime) {}
