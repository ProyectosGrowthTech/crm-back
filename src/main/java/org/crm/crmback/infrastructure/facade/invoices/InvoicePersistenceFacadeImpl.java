package org.crm.crmback.infrastructure.facade.invoices;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.infrastructure.api.controllers.invoice.dto.InvoiceResponse;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.crm.crmback.infrastructure.repository.invoices.InvoiceRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoicePersistenceFacadeImpl implements InvoicePersistenceFacade {

  private final InvoiceRepository invoiceRepository;

  public Invoice findById(Long id) {
    Invoice foundInvoice =
        invoiceRepository
            .findById(id)
            .orElseThrow(() -> new ItemNotFoundException("Invoice " + id + " not found"));
    return foundInvoice;
  }

  @Override
  public Invoice save(Invoice invoice) {
    Invoice resultInvoice = invoiceRepository.save(invoice);
    return resultInvoice;
  }

  @Override
  public InvoiceResponse getInvoices(Integer page, Integer pageSize) {

    Pageable pageable = PageRequest.of(page, pageSize, Sort.by("Id").descending());
    List<Invoice> invoices = invoiceRepository.findAll(pageable);
    long totalInvoices = invoiceRepository.count();
    InvoiceResponse invoiceResponse = new InvoiceResponse(invoices, totalInvoices);
    return invoiceResponse;
  }

  @Override
  public boolean isExistingInvoice(Long id) {
    return invoiceRepository.findById(id).isPresent();
  }

  @Override
  public Invoice deleteInvoiceById(Long id) {
    Invoice invoice = invoiceRepository.findById(id).get();
    invoiceRepository.delete(invoice);
    return invoice;
  }
}
