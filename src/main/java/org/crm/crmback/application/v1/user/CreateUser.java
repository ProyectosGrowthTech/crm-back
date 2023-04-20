package org.crm.crmback.application.v1.user;

import org.crm.crmback.application.v1.user.dto.CreateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/user")
public interface CreateUser {

  @PostMapping
  ResponseEntity<Void> createUser(@RequestBody CreateUserRequest requestBody);

  @PostMapping(path = "/admin")
  ResponseEntity<Void> createAdminUser(@RequestBody CreateUserRequest requestBody);
}
