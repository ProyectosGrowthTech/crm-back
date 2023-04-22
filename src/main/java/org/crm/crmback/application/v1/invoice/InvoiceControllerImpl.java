package org.crm.crmback.application.v1.invoice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.application.v1.invoice.InvoiceController;
import org.crm.crmback.application.v1.invoice.dto.CreateInvoiceRequest;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;
import org.crm.crmback.domain.service.invoice.InvoiceService;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.crm.crmback.infrastructure.security.model.RequestSecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InvoiceControllerImpl implements InvoiceController {

  private final InvoiceService invoiceService;

  private final RequestSecurityContextHolder requestSecurityContextHolder;

  @Override
  public ResponseEntity<Invoice> createInvoice(@Valid CreateInvoiceRequest requestBody) {
    NewInvoiceData newInvoiceData = new NewInvoiceData(requestBody.customerId(), requestBody.invoiceDate(), requestBody.totalAmount(), requestBody.status());
    Invoice resultInvoice = invoiceService.createInvoice(newInvoiceData);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }
}
