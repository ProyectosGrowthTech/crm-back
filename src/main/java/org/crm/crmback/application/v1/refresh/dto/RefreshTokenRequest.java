package org.crm.crmback.application.v1.refresh.dto;

import javax.validation.constraints.NotBlank;

public record RefreshTokenRequest(@NotBlank String refreshToken) {}
