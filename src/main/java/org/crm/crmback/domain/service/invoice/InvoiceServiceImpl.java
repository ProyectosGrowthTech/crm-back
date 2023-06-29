package org.crm.crmback.domain.service.invoice;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.invoice.dto.InvoiceDTO;
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
            .invoiceDate(newInvoiceData.invoiceDate())
            .totalAmount(newInvoiceData.totalAmount())
            .status(newInvoiceData.status())
            .build();
    return invoicePersistenceFacade.save(newInvoice);
  }

  public InvoiceDTO getInvoices(Integer page, Integer pageSize) {
    return invoicePersistenceFacade.getInvoices(page, pageSize);
  }

  public Invoice getInvoiceById(Long id) {
    return invoicePersistenceFacade.findById(id);
  }

  public Invoice deleteInvoiceById(Long id) {
    return invoicePersistenceFacade.deleteInvoiceById(id);
  }
}
