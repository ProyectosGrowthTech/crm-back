package org.crm.crmback.infrastructure.jwt;

import java.util.Map;

public interface JwtFacade {

  String generate(Map<String, Object> claims);

  Map<String, Object> decode(String jwtToken);

  void validate(String jwtToken);
}
