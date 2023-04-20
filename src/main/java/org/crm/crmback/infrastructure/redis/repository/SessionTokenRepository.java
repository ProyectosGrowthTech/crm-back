package org.crm.crmback.infrastructure.redis.repository;

import org.crm.crmback.infrastructure.redis.entity.SessionTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface SessionTokenRepository extends CrudRepository<SessionTokenEntity, String> {}
