package org.crm.crmback.application.v1.service.invoice;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.interfaces.facade.invoice.InvoiceStakeholderPersistanceFacade;
import org.crm.crmback.application.v1.interfaces.repository.invoices.InvoicesStakeholderRepository;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceStakeholderService {
  private final InvoiceStakeholderPersistanceFacade invoiceStakeholderPersistenceFacade;
  private final InvoicesStakeholderRepository invoicesStakeholderRepository;

  public InvoicesStakeholder createInvoiceStakeolder(Invoice invoice, Stakeholder stakeholder) {
    // TODO: Implement logic business to check if invoice already exists, that stakeholder exists, etc.
    InvoicesStakeholder invoiceStakeholder =
        InvoicesStakeholder.builder().invoice(invoice).stakeholder(stakeholder).build();
    return invoicesStakeholderRepository.save(invoiceStakeholder);
  }
}
