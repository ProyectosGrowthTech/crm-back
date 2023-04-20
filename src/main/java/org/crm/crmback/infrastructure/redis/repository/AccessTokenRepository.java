package org.crm.crmback.infrastructure.redis.repository;

import org.crm.crmback.infrastructure.redis.entity.AccessTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccessTokenRepository extends CrudRepository<AccessTokenEntity, String> {}
