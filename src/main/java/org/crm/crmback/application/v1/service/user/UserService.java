package org.crm.crmback.application.v1.service.user;

import org.crm.crmback.domain.model.security.NewUserData;

public interface UserService {

  void createUser(NewUserData user);
}
