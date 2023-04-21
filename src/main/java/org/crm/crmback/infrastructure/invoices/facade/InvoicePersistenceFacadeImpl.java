package org.crm.crmback.infrastructure.invoices.facade;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.crm.crmback.infrastructure.invoices.repository.InvoiceRepository;
import org.crm.crmback.infrastructure.invoices.mapper.InvoiceMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoicePersistenceFacadeImpl implements InvoicePersistenceFacade {

  private final InvoiceRepository InvoiceRepository;

  private final InvoiceMapper InvoiceMapper;

  public Invoice findById(Long Id) {
    InvoiceEntity foundInvoice =
        InvoiceRepository
            .findById(Id)
            .orElseThrow(() -> new ItemNotFoundException("Invoice " + Id + " not found"));
    return InvoiceMapper.invoiceEntityToInvoice(foundInvoice);
  }

  @Override
  public void save(Invoice newInvoice) {
    InvoiceRepository.save(InvoiceMapper.invoiceToInvoiceEntity(newInvoice));
  }

  @Override
  public boolean isExistingInvoice(Long Id) {
    return InvoiceRepository.findById(Id).isPresent();
  }
}
