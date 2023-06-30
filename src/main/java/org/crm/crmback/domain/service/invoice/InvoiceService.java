package org.crm.crmback.domain.service.invoice;

import java.util.List;

import org.crm.crmback.application.v1.invoice.dto.InvoiceDTO;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;

public interface InvoiceService {

  Invoice createInvoice(NewInvoiceData newInvoiceData);

  InvoiceDTO getInvoices(Integer page, Integer pageSize);

  Invoice getInvoiceById(Long id);

  Invoice deleteInvoiceById(Long id);
}
