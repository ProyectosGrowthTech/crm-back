package org.crm.crmback.infrastructure.facade.invoices;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.infrastructure.api.controllers.invoice.dto.InvoiceResponse;

public interface InvoicePersistenceFacade {

  Invoice findById(Long id);

  Invoice save(Invoice newInvoice);

  InvoiceResponse getInvoices(Integer page, Integer pageSize);

  boolean isExistingInvoice(Long id);

  Invoice deleteInvoiceById(Long id);
}
