package org.crm.crmback.infrastructure.rdbms.mapper;

import org.crm.crmback.domain.model.security.User;
import org.crm.crmback.infrastructure.rdbms.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User userEntityToUser(UserEntity userEntity) {
    return User.builder()
        .id(userEntity.getId())
        .username(userEntity.getUsername())
        .createdAt(userEntity.getCreatedAt())
        .password(userEntity.getPassword())
        .isActive(userEntity.isActive())
        .role(userEntity.getRole())
        .build();
  }

  public UserEntity userToUserEntity(User user) {
    return UserEntity.builder()
        .id(user.getId())
        .username(user.getUsername())
        .createdAt(user.getCreatedAt())
        .password(user.getPassword())
        .isActive(user.isActive())
        .role(user.getRole())
        .build();
  }
}
