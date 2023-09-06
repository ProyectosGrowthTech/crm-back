package org.crm.crmback.infrastructure.api.controllers.invoices.dto;

import javax.validation.constraints.Positive;

public record InvoicesItemRequest(
    @Positive Long invoiceId,
    @Positive Long serviceId,
    @Positive Long productId,
    @Positive Integer quantity) {}
