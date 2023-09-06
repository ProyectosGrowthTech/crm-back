package org.crm.crmback.infrastructure.api.controllers.invoices.dto;

import javax.validation.constraints.Positive;

public record InvoicesStackeholderRequest(
    @Positive Long invoicesStackeholderId,
    @Positive Long invoiceId,
    @Positive Long stackeholderId) {}
