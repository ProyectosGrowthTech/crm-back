package org.crm.crmback.infrastructure.api.controllers.invoice;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.application.v1.service.invoice.InvoiceService;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.infrastructure.api.controllers.invoice.dto.InvoiceRequest;
import org.crm.crmback.infrastructure.api.controllers.invoice.dto.InvoiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InvoiceControllerImpl implements InvoiceController {

  private final InvoiceService invoiceService;

  @Override
  public ResponseEntity<Invoice> createInvoice(@Valid InvoiceRequest invoiceRequest) {

    Invoice invoice =
        Invoice.builder()
            .invoiceDate(invoiceRequest.invoiceDate())
            .totalAmount(invoiceRequest.totalAmount())
            .status(invoiceRequest.status())
            .build();

    Invoice resultInvoice = invoiceService.createInvoice(invoice);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }

  @Override
  public ResponseEntity<InvoiceResponse> getInvoices(
      @PositiveOrZero Integer page, @Positive Integer pageSize) {

    InvoiceResponse resultInvoices = invoiceService.getInvoices(page, pageSize);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoices);
  }

  @Override
  public ResponseEntity<Invoice> getInvoiceById(Long id) {

    Invoice resultInvoice = invoiceService.getInvoiceById(id);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }

  @Override
  public ResponseEntity<Void> deleteInvoiceById(Long id) {
    try {
      invoiceService.deleteInvoiceById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
