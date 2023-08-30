package org.crm.crmback.application.v1.interfaces.repository.invoices;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceTypeRepository extends CrudRepository<Invoice, Long> {
  List<Invoice> findAll(Pageable pageable);
}
