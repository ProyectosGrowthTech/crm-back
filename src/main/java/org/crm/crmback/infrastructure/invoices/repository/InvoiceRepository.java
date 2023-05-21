package org.crm.crmback.infrastructure.invoices.repository;

import java.util.List;
import java.util.Optional;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {
  Optional<InvoiceEntity> findById(Long id);

  List<InvoiceEntity> findAll(Pageable pageable);
}
