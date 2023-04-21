package org.crm.crmback.application.v1.invoice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;

public record CreateInvoiceRequest(@Positive Long customerId, Date invoiceDate,
                                   BigDecimal totalAmount, @NotBlank String status) {}
