package org.crm.crmback.infrastructure.invoices.facade;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.security.User;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;

public interface InvoicePersistenceFacade {

  Invoice findById(Long id);

  Invoice save(Invoice newInvoice);

  boolean isExistingInvoice(Long id);
}
