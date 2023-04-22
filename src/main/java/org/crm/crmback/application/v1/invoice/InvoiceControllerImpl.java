package org.crm.crmback.application.v1.invoice;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.application.v1.invoice.dto.InvoiceRequest;
import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.NewInvoiceData;
import org.crm.crmback.domain.service.invoice.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InvoiceControllerImpl implements InvoiceController {

  private final InvoiceService invoiceService;

  @Override
  public ResponseEntity<Invoice> createInvoice(@Valid InvoiceRequest requestBody) {
    NewInvoiceData newInvoiceData =
        new NewInvoiceData(
            requestBody.customerId(),
            requestBody.invoiceDate(),
            requestBody.totalAmount(),
            requestBody.status());
    Invoice resultInvoice = invoiceService.createInvoice(newInvoiceData);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }

  @Override
  public ResponseEntity<List<Invoice>> getInvoices(@Valid InvoiceRequest requestBody) {

    List<Invoice> resultInvoices =
        invoiceService.getInvoices(requestBody.page(), requestBody.pageSize());
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoices);
  }

  @Override
  public ResponseEntity<Invoice> getInvoiceById(@Valid InvoiceRequest requestBody) {

    Invoice resultInvoice = invoiceService.getInvoiceById(requestBody.invoiceId());
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }

  @Override
  public ResponseEntity<List<Invoice>> getInvoicesByCustomerId(InvoiceRequest requestBody) {
    List<Invoice> resultInvoice =
        invoiceService.getInvoicesByCustomerId(
            requestBody.customerId(), requestBody.page(), requestBody.pageSize());
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }
}
