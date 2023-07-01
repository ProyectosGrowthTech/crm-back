package org.crm.crmback.infrastructure.api.controllers.invoice.dto;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Positive;

public record InvoiceRequest(
    @Positive Long invoiceId, Date invoiceDate, BigDecimal totalAmount, String status, Long stakeHolderId) {}
