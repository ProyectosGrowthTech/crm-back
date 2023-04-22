package org.crm.crmback.infrastructure.invoices.facade;

import java.util.List;
import org.crm.crmback.domain.model.invoices.Invoice;

public interface InvoicePersistenceFacade {

  Invoice findById(Long id);

  List<Invoice> findBycustomerId(Long customerId, Integer page, Integer pageSize);

  Invoice save(Invoice newInvoice);

  List<Invoice> getInvoices(Integer page, Integer pageSize);

  boolean isExistingInvoice(Long id);
}
