package org.crm.crmback.application.v1.refresh;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.refresh.dto.RefreshTokenRequest;
import org.crm.crmback.application.v1.shared.dto.LoginCredentialsResponse;
import org.crm.crmback.domain.model.security.LoginTokens;
import org.crm.crmback.domain.service.authentication.RefreshService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RefreshControllerImpl implements RefreshController {

  private final RefreshService refreshService;

  @Override
  public ResponseEntity<LoginCredentialsResponse> refreshToken(RefreshTokenRequest request) {
    LoginTokens tokens = refreshService.refreshToken(request.refreshToken());
    LoginCredentialsResponse response =
        new LoginCredentialsResponse(tokens.accessToken(), tokens.refreshToken());
    return ResponseEntity.ok(response);
  }
}
