package org.crm.crmback.infrastructure.rdbms.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private String password;

  private LocalDateTime createdAt;

  private boolean isActive;

  @Enumerated(EnumType.STRING)
  private Role role;
}
