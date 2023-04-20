package org.crm.crmback.domain.model.security;

public record Credentials(String username, String plainTextPassword, String userIp) {}
