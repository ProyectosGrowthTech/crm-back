package org.crm.crmback.domain.service.user;

import org.crm.crmback.domain.model.security.NewUserData;

public interface UserService {

  void createUser(NewUserData user);
}
