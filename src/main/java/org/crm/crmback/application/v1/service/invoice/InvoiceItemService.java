package org.crm.crmback.application.v1.service.invoice;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.interfaces.repository.invoices.InvoicesItemRepository;
import org.crm.crmback.domain.model.invoices.InvoicesItem;
import org.crm.crmback.infrastructure.api.controllers.invoices.dto.InvoicesItemResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceItemService {

  private final InvoicesItemRepository invoicesItemRepository;

  public InvoicesItem createInvoicesItems(InvoicesItem invoicesItem) {
    // TODO: Implement logic business to check if invoice already exists, that customer exists, etc.
    return invoicesItemRepository.save(invoicesItem);
  }

  public InvoicesItemResponse getItemsByInvoiceId(Integer page, Integer pageSize, Long invoiceId) {
    Pageable pageable = PageRequest.of(page, pageSize, Sort.by("Id").descending());
    List<InvoicesItem> invoiceItems = invoicesItemRepository.findItemsByInvoiceId(pageable,invoiceId);
    long totalItems = invoicesItemRepository.findItemsByInvoiceId().size();
    InvoicesItemResponse invoicesItemRepository = new InvoicesItemResponse(invoiceItems, totalItems);
    return invoicesItemRepository;
  }

  public InvoicesItem deleteItemById(Long id) {
    InvoicesItem item = invoicesItemRepository.findById(id).get();
    invoicesItemRepository.delete(item);
    return item;
  }


}
