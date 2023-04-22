package org.crm.crmback.domain.service.invoice;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;
import org.crm.crmback.infrastructure.invoices.facade.InvoicePersistenceFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

  private final InvoicePersistenceFacade invoicePersistenceFacade;

  @Override
  public Invoice createInvoice(NewInvoiceData newInvoiceData) {
    // TODO: Implement logic business to check if invoice already exists, that customer exists, etc.
    Invoice newInvoice =
        Invoice.builder()
            .customerId(newInvoiceData.customerId())
            .invoiceDate(newInvoiceData.invoiceDate())
            .totalAmount(newInvoiceData.totalAmount())
            .status(newInvoiceData.status())
            .build();
    return invoicePersistenceFacade.save(newInvoice);
  }

  public List<Invoice> getInvoices(Integer page, Integer pageSize) {
    return invoicePersistenceFacade.getInvoices(page, pageSize);
  }

  public Invoice getInvoiceById(Long id) {
    return invoicePersistenceFacade.findById(id);
  }

  public List<Invoice> getInvoicesByCustomerId(Long customerId, Integer page, Integer pageSize) {
    return invoicePersistenceFacade.findBycustomerId(customerId, page, pageSize);
  }
}
