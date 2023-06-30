package org.crm.crmback.infrastructure.invoices.facade;

import java.util.List;

import org.crm.crmback.application.v1.invoice.dto.InvoiceDTO;
import org.crm.crmback.domain.model.invoices.Invoice;

public interface InvoicePersistenceFacade {

  Invoice findById(Long id);

  Invoice save(Invoice newInvoice);

  InvoiceDTO getInvoices(Integer page, Integer pageSize);

  boolean isExistingInvoice(Long id);

  Invoice deleteInvoiceById(Long id);
}
