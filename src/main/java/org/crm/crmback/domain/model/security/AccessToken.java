package org.crm.crmback.domain.model.security;

import java.time.Duration;

public record AccessToken(
    String token, Duration lifetime, RefreshToken refreshToken, IdentityToken identityToken) {}
