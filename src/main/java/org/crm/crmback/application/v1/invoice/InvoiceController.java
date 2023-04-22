package org.crm.crmback.application.v1.invoice;

import org.crm.crmback.application.v1.invoice.dto.CreateInvoiceRequest;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.PermitAll;

@RequestMapping("/v1/Invoice")
public interface InvoiceController {

  @PutMapping
  @PermitAll
  ResponseEntity<Invoice> createInvoice(@RequestBody CreateInvoiceRequest requestBody);
}
