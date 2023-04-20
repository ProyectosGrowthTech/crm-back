package org.crm.crmback.infrastructure.rdbms.facade;

import org.crm.crmback.domain.model.security.User;

public interface UserPersistenceFacade {

  User findByUsername(String username);

  void save(User newUser);

  boolean isExistingUser(String username);
}
