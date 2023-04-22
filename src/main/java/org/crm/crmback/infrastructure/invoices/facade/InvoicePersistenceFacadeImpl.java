package org.crm.crmback.infrastructure.invoices.facade;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.crm.crmback.infrastructure.invoices.mapper.InvoiceMapper;
import org.crm.crmback.infrastructure.invoices.repository.InvoiceRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoicePersistenceFacadeImpl implements InvoicePersistenceFacade {

  private final InvoiceRepository invoiceRepository;

  private final InvoiceMapper invoiceMapper;

  public Invoice findById(Long id) {
    InvoiceEntity foundInvoice =
        invoiceRepository
            .findById(id)
            .orElseThrow(() -> new ItemNotFoundException("Invoice " + id + " not found"));
    return invoiceMapper.invoiceEntityToInvoice(foundInvoice);
  }

  @Override
  public Invoice save(Invoice newInvoice) {
    InvoiceEntity resultInvoice =
        invoiceRepository.save(invoiceMapper.invoiceToInvoiceEntity(newInvoice));
    return invoiceMapper.invoiceEntityToInvoice(resultInvoice);
  }

  @Override
  public boolean isExistingInvoice(Long id) {
    return invoiceRepository.findById(id).isPresent();
  }
}
