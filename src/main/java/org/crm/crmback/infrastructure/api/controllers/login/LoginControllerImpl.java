package org.crm.crmback.infrastructure.api.controllers.login;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.service.authentication.LoginService;
import org.crm.crmback.domain.model.security.Credentials;
import org.crm.crmback.domain.model.security.LoginTokens;
import org.crm.crmback.infrastructure.api.controllers.login.dto.LoginRequest;
import org.crm.crmback.infrastructure.api.controllers.shared.dto.LoginCredentialsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {

  private final LoginService loginService;

  @Override
  public ResponseEntity<LoginCredentialsResponse> login(@Valid LoginRequest request) {
    Credentials credentials = new Credentials(request.username(), request.password(), "");
    LoginTokens tokens = loginService.login(credentials);
    return ResponseEntity.ok(
        new LoginCredentialsResponse(tokens.accessToken(), tokens.refreshToken()));
  }
}
