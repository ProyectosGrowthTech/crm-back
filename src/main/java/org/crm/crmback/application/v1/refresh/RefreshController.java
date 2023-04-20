package org.crm.crmback.application.v1.refresh;

import org.crm.crmback.application.v1.refresh.dto.RefreshTokenRequest;
import org.crm.crmback.application.v1.shared.dto.LoginCredentialsResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/authentication")
public interface RefreshController {

  @PostMapping(
      path = "/token/refresh",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<LoginCredentialsResponse> refreshToken(@RequestBody RefreshTokenRequest request);
}
