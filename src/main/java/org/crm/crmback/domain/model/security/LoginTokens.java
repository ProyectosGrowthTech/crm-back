package org.crm.crmback.domain.model.security;

public record LoginTokens(String accessToken, String refreshToken, String sessionId) {}
