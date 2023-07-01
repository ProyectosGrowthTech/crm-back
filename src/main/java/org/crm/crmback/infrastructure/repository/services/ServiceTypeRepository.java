package org.crm.crmback.infrastructure.repository.services;

import org.crm.crmback.domain.model.services.ServiceTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceTypeRepository extends CrudRepository<ServiceTypeEntity, Long> {}
