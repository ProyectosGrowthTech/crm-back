package org.crm.crmback.application.v1.invoice.dto;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public record CreateInvoiceRequest(
    @Positive Long customerId, Date invoiceDate, BigDecimal totalAmount, @NotBlank String status) {}
