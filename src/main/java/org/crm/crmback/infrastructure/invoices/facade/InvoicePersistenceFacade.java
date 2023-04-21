package org.crm.crmback.infrastructure.invoices.facade;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.security.User;

public interface InvoicePersistenceFacade {

  Invoice findById(Long id);

  void save(Invoice newInvoice);

  boolean isExistingInvoice(Long id);
}
