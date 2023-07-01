package org.crm.crmback.infrastructure.api.controllers.user.dto;

import javax.validation.constraints.NotBlank;

public record CreateUserRequest(@NotBlank String username, @NotBlank String password) {}
