package org.crm.crmback.infrastructure.invoices.repository;

import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.crm.crmback.infrastructure.rdbms.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {
  Optional<InvoiceEntity> findById(Long id);
}
