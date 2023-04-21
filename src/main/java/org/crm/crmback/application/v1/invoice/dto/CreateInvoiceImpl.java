package org.crm.crmback.application.v1.invoice.dto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.application.v1.invoice.CreateInvoice;
import org.crm.crmback.application.v1.user.CreateUser;
import org.crm.crmback.application.v1.user.dto.CreateUserRequest;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;
import org.crm.crmback.domain.model.security.NewUserData;
import org.crm.crmback.domain.service.invoice.InvoiceService;
import org.crm.crmback.domain.service.user.UserService;
import org.crm.crmback.infrastructure.security.annotation.Authorized;
import org.crm.crmback.infrastructure.security.model.RequestSecurityContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CreateInvoiceImpl implements CreateInvoice {

  private final InvoiceService invoiceService;

  private final RequestSecurityContextHolder requestSecurityContextHolder;

  @Override
  public ResponseEntity<Void> createInvoice(@Valid CreateInvoiceRequest requestBody) {
    NewInvoiceData newInvoiceData = new NewInvoiceData(requestBody.customerId(), requestBody.invoiceDate(), requestBody.totalAmount(), requestBody.status());
    invoiceService.createInvoice(newInvoiceData);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
