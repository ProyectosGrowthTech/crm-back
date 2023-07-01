package org.crm.crmback.infrastructure.repository.services;

import org.crm.crmback.domain.model.services.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {}
