package org.crm.crmback.application.v1.service.invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.interfaces.repository.invoices.InvoiceRepository;
import org.crm.crmback.application.v1.service.stakeholder.StakeholderService;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;
import org.crm.crmback.infrastructure.api.controllers.invoices.dto.InvoiceResponse;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {

  private final InvoiceRepository invoiceRepository;
  private final StakeholderService stakeholderService;
  private final InvoiceStakeholderService invoiceStakeholderservice;

  public Invoice createInvoice(Invoice invoice, List<Long> stakeholders) {
    // TODO: Implement logic business to check if invoice already exists, that customer exists, etc.
    List<InvoicesStakeholder> invoiceStakeholder = new ArrayList<>();
    stakeholders.stream()
        .map(
            m ->
                invoiceStakeholder.add(
                    invoiceStakeholderservice.createInvoiceStakeolder(
                        invoice, stakeholderService.getStakeholderById(m))));
    invoice.setInvoicesStakeholders(Set.copyOf(invoiceStakeholder));
    return invoiceRepository.save(invoice);
  }

  public InvoiceResponse getInvoices(Integer page, Integer pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize, Sort.by("Id").descending());
    List<Invoice> invoices = invoiceRepository.findAll(pageable);
    long totalInvoices = invoiceRepository.count();
    InvoiceResponse invoiceResponse = new InvoiceResponse(invoices, totalInvoices);
    return invoiceResponse;
  }

  public Invoice getInvoiceById(Long id) {
    Invoice foundInvoice =
        invoiceRepository
            .findById(id)
            .orElseThrow(() -> new ItemNotFoundException("Invoice " + id + " not found"));
    return foundInvoice;
  }

  public Invoice deleteInvoiceById(Long id) {
    Invoice invoice = invoiceRepository.findById(id).get();
    invoiceRepository.delete(invoice);
    return invoice;
  }
}
