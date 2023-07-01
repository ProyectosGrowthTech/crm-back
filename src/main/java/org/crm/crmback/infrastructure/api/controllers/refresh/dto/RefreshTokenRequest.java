package org.crm.crmback.infrastructure.api.controllers.refresh.dto;

import javax.validation.constraints.NotBlank;

public record RefreshTokenRequest(@NotBlank String refreshToken) {}
