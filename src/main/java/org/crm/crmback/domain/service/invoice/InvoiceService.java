package org.crm.crmback.domain.service.invoice;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;
import org.crm.crmback.domain.model.security.NewUserData;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;

public interface InvoiceService {

  Invoice createInvoice(NewInvoiceData newInvoiceData);
}
