package org.crm.crmback.infrastructure.security.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Getter
@Setter
@ToString
@Component
@RequestScope
public class RequestSecurityContextHolder {

  private UserClaims claims;
}
