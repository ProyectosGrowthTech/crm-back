package org.crm.crmback.application.v1.interfaces.repository.services;

import java.util.List;
import org.crm.crmback.domain.model.services.ServiceType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ServiceTypeRepository extends CrudRepository<ServiceType, Long> {
  List<ServiceType> findAll(Pageable pageable);
}
