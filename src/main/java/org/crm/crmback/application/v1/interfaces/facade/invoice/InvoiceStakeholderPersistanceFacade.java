package org.crm.crmback.application.v1.interfaces.facade.invoice;

import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;

public interface InvoiceStakeholderPersistanceFacade {
  InvoicesStakeholder save(InvoicesStakeholder newInvoice);

  InvoicesStakeholder deleteInvoiceById(Long id);
}
