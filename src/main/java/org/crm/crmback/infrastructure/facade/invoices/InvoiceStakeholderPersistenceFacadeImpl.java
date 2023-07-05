package org.crm.crmback.infrastructure.facade.invoices;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.interfaces.facade.invoice.InvoiceStakeholderPersistanceFacade;
import org.crm.crmback.application.v1.interfaces.repository.invoices.InvoicesStakeholderRepository;
import org.crm.crmback.application.v1.service.invoice.InvoiceStakeholderService;
import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceStakeholderPersistenceFacadeImpl
    implements InvoiceStakeholderPersistanceFacade {

  private final InvoicesStakeholderRepository invoicesStakeholderRepository;

  @Override
  public InvoicesStakeholder save(InvoicesStakeholder invoiceStakeholder) {
    return invoicesStakeholderRepository.save(invoiceStakeholder);
  }

  @Override
  public InvoicesStakeholder deleteInvoiceById(Long id) {
    return null;
  }
}
