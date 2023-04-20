package org.crm.crmback.domain.model.security;

import java.time.Duration;

public record RefreshToken(
    String token, Duration lifetime, SessionToken sessionToken, IdentityToken identityToken) {}
