package org.crm.crmback.application.v1.invoice;

import org.crm.crmback.application.v1.invoice.dto.CreateInvoiceRequest;
import org.crm.crmback.application.v1.user.dto.CreateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/invoice")
public interface CreateInvoice {

  @PostMapping
  ResponseEntity<Void> createInvoice(@RequestBody CreateInvoiceRequest requestBody);
}
