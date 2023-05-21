package org.crm.crmback.application.v1.invoice;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
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
            requestBody.invoiceDate(), requestBody.totalAmount(), requestBody.status());
    Invoice resultInvoice = invoiceService.createInvoice(newInvoiceData);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }

  @Override
  public ResponseEntity<List<Invoice>> getInvoices(
      @PositiveOrZero Integer page, @Positive Integer pageSize) {

    List<Invoice> resultInvoices = invoiceService.getInvoices(page, pageSize);
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
