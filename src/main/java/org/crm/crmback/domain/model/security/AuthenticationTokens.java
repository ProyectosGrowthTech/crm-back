package org.crm.crmback.domain.model.security;

public record AuthenticationTokens(
    AccessToken accessToken,
    RefreshToken refreshToken,
    SessionToken sessionToken,
    IdentityToken identityToken) {}
