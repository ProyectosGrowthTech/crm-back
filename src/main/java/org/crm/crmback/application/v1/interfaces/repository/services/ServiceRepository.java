package org.crm.crmback.application.v1.interfaces.repository.services;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.services.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepository extends CrudRepository<Service, Long> {
  List<Service> findAll(Pageable pageable);
}
