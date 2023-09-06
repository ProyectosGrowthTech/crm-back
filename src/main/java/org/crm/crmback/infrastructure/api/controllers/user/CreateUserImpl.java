package org.crm.crmback.infrastructure.api.controllers.user;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.application.v1.service.user.UserService;
import org.crm.crmback.domain.model.security.NewUserData;
import org.crm.crmback.infrastructure.api.controllers.user.dto.CreateUserRequest;
import org.crm.crmback.infrastructure.security.annotation.Authorized;
import org.crm.crmback.infrastructure.security.model.RequestSecurityContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CreateUserImpl implements CreateUser {

  private final UserService userService;

  private final RequestSecurityContextHolder requestSecurityContextHolder;

  @Override
  public ResponseEntity<Void> createUser(@Valid CreateUserRequest requestBody) {
    NewUserData userData = new NewUserData(requestBody.username(), requestBody.password());
    userService.createUser(userData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Override
  @Authorized(allowedRoles = {"ADMIN"})
  public ResponseEntity<Void> createAdminUser(CreateUserRequest requestBody) {
    log.info("{}", requestSecurityContextHolder.getClaims());
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
