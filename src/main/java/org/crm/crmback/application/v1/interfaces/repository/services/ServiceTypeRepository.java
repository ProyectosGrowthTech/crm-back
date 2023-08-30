package org.crm.crmback.application.v1.interfaces.repository.services;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.services.ServiceType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceTypeRepository extends CrudRepository<ServiceType, Long> {
  List<ServiceType> findAll(Pageable pageable);
}
