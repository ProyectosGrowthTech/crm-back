package org.crm.crmback.infrastructure.api.controllers.invoice.dto;

import java.util.List;
import org.crm.crmback.domain.model.invoices.Invoice;

public record InvoiceResponse(List<Invoice> invoiceList, Long totalInvoices) {}
