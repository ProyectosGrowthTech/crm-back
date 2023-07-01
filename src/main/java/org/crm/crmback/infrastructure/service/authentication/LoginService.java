package org.crm.crmback.infrastructure.service.authentication;

import org.crm.crmback.domain.model.security.Credentials;
import org.crm.crmback.domain.model.security.LoginTokens;

public interface LoginService {

  LoginTokens login(Credentials credentials);
}
