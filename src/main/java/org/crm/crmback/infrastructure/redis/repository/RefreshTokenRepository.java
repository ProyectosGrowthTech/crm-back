package org.crm.crmback.infrastructure.redis.repository;

import org.crm.crmback.infrastructure.redis.entity.RefreshTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, String> {}
