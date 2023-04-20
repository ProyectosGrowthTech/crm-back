package org.crm.crmback.infrastructure.configuration.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
public record AuthenticationConfig(@NotNull List<String> excluded) {}
