package org.crm.crmback.application.v1.user.dto;

import javax.validation.constraints.NotBlank;

public record CreateUserRequest(@NotBlank String username, @NotBlank String password) {}
