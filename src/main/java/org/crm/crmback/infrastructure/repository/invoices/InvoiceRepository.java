package org.crm.crmback.infrastructure.repository.invoices;

import java.util.List;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

  List<Invoice> findAll(Pageable pageable);
}
