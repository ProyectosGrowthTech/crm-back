package org.crm.crmback.application.v1.service.invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.interfaces.facade.invoice.InvoicePersistenceFacade;
import org.crm.crmback.application.v1.service.stakeholder.StakeholderService;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;
import org.crm.crmback.infrastructure.api.controllers.invoice.dto.InvoiceResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {

  private final InvoicePersistenceFacade invoicePersistenceFacade;
  private final StakeholderService stakeholderService;
  private final InvoiceStakeholderService invoiceStakeholderservice;

  public Invoice createInvoice(Invoice invoice, List<Long> stakeholders) {
    // TODO: Implement logic business to check if invoice already exists, that customer exists, etc.
    List<InvoicesStakeholder> invoiceStakeholder = new ArrayList<>();
    for (Long stakeholder : stakeholders) {
      invoiceStakeholder.add(
          invoiceStakeholderservice.createInvoiceStakeolder(
              invoice, stakeholderService.getStakeholderById(stakeholder)));
    }
    invoice.setInvoicesStakeholders(Set.copyOf(invoiceStakeholder));
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
