package org.crm.crmback.application.v1.invoice.dto;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Positive;

public record InvoiceRequest(
    @Positive Long invoiceId, Date invoiceDate, BigDecimal totalAmount, String status) {}
