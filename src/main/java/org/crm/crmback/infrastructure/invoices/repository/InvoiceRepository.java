package org.crm.crmback.infrastructure.invoices.repository;

import java.util.Optional;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {
  Optional<InvoiceEntity> findById(Long id);
}
