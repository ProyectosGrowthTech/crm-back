package org.crm.crmback.application.v1.invoice;

import java.util.List;
import org.crm.crmback.application.v1.invoice.dto.InvoiceRequest;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/invoice")
public interface InvoiceController {

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceRequest requestBody);

  @GetMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<Invoice>> getInvoices(
      @RequestParam(name = "page", defaultValue = "1") Integer page,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize);

  @GetMapping(
      path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Long id);

  @GetMapping(
      path = "/customer/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<Invoice>> getInvoicesByCustomerId(
      @PathVariable("id") Long id,
      @RequestParam(name = "page", defaultValue = "1") Integer page,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize);

  @DeleteMapping(
      path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Void> deleteInvoiceById(@PathVariable("id") Long id);
}
