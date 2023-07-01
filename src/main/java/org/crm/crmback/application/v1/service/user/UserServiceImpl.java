package org.crm.crmback.application.v1.service.user;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.exception.UserAlreadyExistsException;
import org.crm.crmback.domain.model.security.NewUserData;
import org.crm.crmback.domain.model.security.User;
import org.crm.crmback.infrastructure.hash.HashFacade;
import org.crm.crmback.infrastructure.rdbms.entity.Role;
import org.crm.crmback.infrastructure.rdbms.facade.UserPersistenceFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final HashFacade hashFacade;

  private final UserPersistenceFacade userPersistenceFacade;

  @Override
  public void createUser(NewUserData userData) {
    String hashedPassword = hashFacade.hash(userData.password());
    if (userPersistenceFacade.isExistingUser(userData.username())) {
      throw new UserAlreadyExistsException("user with given username already exists");
    }
    User newUser =
        User.builder()
            .username(userData.username())
            .password(hashedPassword)
            .createdAt(LocalDateTime.now(ZoneOffset.UTC))
            .isActive(false)
            .role(Role.USER)
            .build();
    userPersistenceFacade.save(newUser);
  }
}
