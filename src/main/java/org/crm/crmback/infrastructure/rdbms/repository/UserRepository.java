package org.crm.crmback.infrastructure.rdbms.repository;

import java.util.Optional;
import org.crm.crmback.infrastructure.rdbms.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
  Optional<UserEntity> findByUsername(String username);
}
