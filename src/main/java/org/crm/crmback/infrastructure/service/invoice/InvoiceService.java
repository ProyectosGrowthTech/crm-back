package org.crm.crmback.infrastructure.service.invoice;

import org.crm.crmback.infrastructure.api.controllers.invoice.dto.InvoiceResponse;
import org.crm.crmback.domain.model.invoices.Invoice;

public interface InvoiceService {

  Invoice createInvoice(Invoice invoice);

  InvoiceResponse getInvoices(Integer page, Integer pageSize);

  Invoice getInvoiceById(Long id);

  Invoice deleteInvoiceById(Long id);
}
