package org.crm.crmback.domain.service.authentication;

import org.crm.crmback.domain.model.security.LoginTokens;

public interface RefreshService {

  LoginTokens refreshToken(String refreshToken);
}
