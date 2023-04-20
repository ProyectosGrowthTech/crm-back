package org.crm.crmback.domain.model.security;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.crm.crmback.infrastructure.rdbms.entity.Role;

@Data
@Builder
@AllArgsConstructor
public class User {

  private Long id;

  private String username;

  private String password;

  private Role role;

  private LocalDateTime createdAt;

  private boolean isActive;

  private String userIp;

  public Map<String, Object> serializeClaims() {
    return Map.of("id", id, "username", username, "role", role.toString());
  }
}
