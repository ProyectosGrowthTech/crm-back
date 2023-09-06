package org.crm.crmback.infrastructure.api.controllers.shared.dto;

public record LoginCredentialsResponse(String accessToken, String refreshToken) {}
