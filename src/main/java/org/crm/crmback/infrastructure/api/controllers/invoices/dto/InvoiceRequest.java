package org.crm.crmback.infrastructure.api.controllers.invoices.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Positive;

public record InvoiceRequest(
    @Positive Long invoiceId,
    Date invoiceDate,
    BigDecimal totalAmount,
    String status,
    List<Long> stakeHolderId) {}
