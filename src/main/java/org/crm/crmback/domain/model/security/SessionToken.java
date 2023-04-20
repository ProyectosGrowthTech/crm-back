package org.crm.crmback.domain.model.security;

import java.time.Duration;

public record SessionToken(String token, Duration lifetime, IdentityToken identityToken) {}
