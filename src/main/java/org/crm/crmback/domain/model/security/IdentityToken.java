package org.crm.crmback.domain.model.security;

import java.time.Duration;

public record IdentityToken(String token, Duration lifetime) {}
