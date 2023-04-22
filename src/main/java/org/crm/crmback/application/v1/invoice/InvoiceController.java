package org.crm.crmback.application.v1.invoice;

import java.util.List;
import org.crm.crmback.application.v1.invoice.dto.InvoiceRequest;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/invoice")
public interface InvoiceController {

  @PutMapping(
      path = "/createInvoice",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceRequest requestBody);

  @GetMapping(
      path = "/getInvoices",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<Invoice>> getInvoices(@RequestBody InvoiceRequest requestBody);

  @GetMapping(
      path = "/getInvoiceById",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Invoice> getInvoiceById(@RequestBody InvoiceRequest requestBody);

  @GetMapping(
      path = "/getInvoicesByCustomerId",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<List<Invoice>> getInvoicesByCustomerId(@RequestBody InvoiceRequest requestBody);
}
