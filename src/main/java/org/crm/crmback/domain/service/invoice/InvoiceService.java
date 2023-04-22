package org.crm.crmback.domain.service.invoice;

import java.util.List;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;

public interface InvoiceService {

  Invoice createInvoice(NewInvoiceData newInvoiceData);

  List<Invoice> getInvoices(Integer page, Integer pageSize);
}
