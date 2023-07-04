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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/invoice")
public class InvoiceController {

  private final InvoiceService invoiceService;

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Invoice> createInvoice(@RequestBody @Valid InvoiceRequest invoiceRequest) {

    Invoice invoice =
        Invoice.builder()
            .invoiceDate(invoiceRequest.invoiceDate())
            .totalAmount(invoiceRequest.totalAmount())
            .status(invoiceRequest.status())
            .build();

    Invoice resultInvoice = invoiceService.createInvoice(invoice, invoiceRequest.stakeHolderId());
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<InvoiceResponse> getInvoices(
      @PositiveOrZero @RequestParam(name = "page", defaultValue = "0") Integer page,
      @Positive @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

    InvoiceResponse resultInvoices = invoiceService.getInvoices(page, pageSize);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoices);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(
      path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Long id) {

    Invoice resultInvoice = invoiceService.getInvoiceById(id);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(
      path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteInvoiceById(@PathVariable("id") Long id) {
    try {
      invoiceService.deleteInvoiceById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
