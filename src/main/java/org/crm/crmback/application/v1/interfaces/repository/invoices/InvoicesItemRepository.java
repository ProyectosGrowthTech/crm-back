package org.crm.crmback.application.v1.interfaces.repository.invoices;

import java.util.List;
import org.crm.crmback.domain.model.invoices.InvoicesItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface InvoicesItemRepository extends CrudRepository<InvoicesItem, Long> {
  List<InvoicesItem> findAll(Pageable pageable);

  List<InvoicesItem> findItemsByInvoiceId(Pageable pageable, Long invoiceId);

  List<InvoicesItem> findItemsByInvoiceId(Long invoiceId);
}
