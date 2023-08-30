package org.crm.crmback.application.v1.interfaces.facade.invoice;

import org.crm.crmback.domain.model.invoices.InvoicesItem;
import org.crm.crmback.infrastructure.api.controllers.invoices.dto.InvoicesItemResponse;

public interface InvoicesItemPersistenceFacade {

  InvoicesItem findById(Long id);
  InvoicesItemResponse getItemsByInvoiceId(Integer page, Integer pageSize, Integer invoiceId);

  InvoicesItem save(InvoicesItem newItem);


  boolean isExistingInvoice(Long id);

  InvoicesItem deleteItemById(Long id);
}
