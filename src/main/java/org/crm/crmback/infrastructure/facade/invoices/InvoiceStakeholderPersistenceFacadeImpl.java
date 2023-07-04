package org.crm.crmback.infrastructure.facade.invoices;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.interfaces.facade.invoice.InvoiceStakeholderPersistanceFacade;
import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceStakeholderPersistenceFacadeImpl
    implements InvoiceStakeholderPersistanceFacade {

  private final InvoiceStakeholderPersistanceFacade invoiceStakeholderPersistanceFacade;

  @Override
  public InvoicesStakeholder save(InvoicesStakeholder invoiceStakeholder) {
    return invoiceStakeholderPersistanceFacade.save(invoiceStakeholder);
  }

  @Override
  public InvoicesStakeholder deleteInvoiceById(Long id) {
    return null;
  }
}
