package org.crm.crmback.infrastructure.api.controllers.invoices.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import org.crm.crmback.domain.model.invoices.Invoice;

public record InvoiceResponse(
    @JsonManagedReference List<Invoice> invoiceList, Long totalInvoices) {}
