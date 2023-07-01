package org.crm.crmback.application.v1.service.invoice;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.infrastructure.api.controllers.invoice.dto.InvoiceResponse;
import org.crm.crmback.infrastructure.facade.invoices.InvoicePersistenceFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {

  private final InvoicePersistenceFacade invoicePersistenceFacade;

  public Invoice createInvoice(Invoice invoice) {
    // TODO: Implement logic business to check if invoice already exists, that customer exists, etc.

    return invoicePersistenceFacade.save(invoice);
  }

  public InvoiceResponse getInvoices(Integer page, Integer pageSize) {
    return invoicePersistenceFacade.getInvoices(page, pageSize);
  }

  public Invoice getInvoiceById(Long id) {
    return invoicePersistenceFacade.findById(id);
  }

  public Invoice deleteInvoiceById(Long id) {
    return invoicePersistenceFacade.deleteInvoiceById(id);
  }
}
