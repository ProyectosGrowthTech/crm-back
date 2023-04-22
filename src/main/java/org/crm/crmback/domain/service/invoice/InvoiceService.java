package org.crm.crmback.domain.service.invoice;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;

public interface InvoiceService {

  Invoice createInvoice(NewInvoiceData newInvoiceData);
}
