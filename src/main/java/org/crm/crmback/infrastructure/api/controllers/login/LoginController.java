package org.crm.crmback.infrastructure.api.controllers.login;

import org.crm.crmback.infrastructure.api.controllers.login.dto.LoginRequest;
import org.crm.crmback.infrastructure.api.controllers.shared.dto.LoginCredentialsResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/authentication")
public interface LoginController {

  @PostMapping(
      path = "/login",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<LoginCredentialsResponse> login(@RequestBody LoginRequest request);
}
