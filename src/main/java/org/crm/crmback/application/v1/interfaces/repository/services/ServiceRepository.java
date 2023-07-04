package org.crm.crmback.application.v1.interfaces.repository.services;

import org.crm.crmback.domain.model.services.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Long> {}
