package org.crm.crmback.application.v1.invoice.dto;

import org.crm.crmback.domain.model.invoices.Invoice;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record InvoiceDTO(
        List<Invoice> invoiceList, Long totalInvoices
) {}
