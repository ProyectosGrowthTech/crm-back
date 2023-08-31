package org.crm.crmback.infrastructure.api.controllers.invoices.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.crm.crmback.domain.model.invoices.Invoice;



public record InvoiceResponse(@JsonManagedReference List<Invoice> invoiceList, Long totalInvoices) {}
