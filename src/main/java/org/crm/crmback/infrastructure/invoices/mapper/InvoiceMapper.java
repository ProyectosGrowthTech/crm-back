package org.crm.crmback.infrastructure.invoices.mapper;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.infrastructure.invoices.entity.InvoiceEntity;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

  public Invoice invoiceEntityToInvoice(InvoiceEntity invoiceEntity) {
    return Invoice.builder()
        .id(invoiceEntity.getId())
        .invoiceDate(invoiceEntity.getInvoiceDate())
        .totalAmount(invoiceEntity.getTotalAmount())
        .status(invoiceEntity.getStatus())
        .build();
  }

  public InvoiceEntity invoiceToInvoiceEntity(Invoice invoice) {
    return InvoiceEntity.builder()
        .id(invoice.getId())
        .invoiceDate(invoice.getInvoiceDate())
        .totalAmount(invoice.getTotalAmount())
        .status(invoice.getStatus())
        .build();
  }
}
