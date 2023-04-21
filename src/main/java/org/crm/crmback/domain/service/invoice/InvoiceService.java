package org.crm.crmback.domain.service.invoice;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;
import org.crm.crmback.domain.model.security.NewUserData;

public interface InvoiceService {

  void createInvoice(NewInvoiceData newInvoiceData);
}
