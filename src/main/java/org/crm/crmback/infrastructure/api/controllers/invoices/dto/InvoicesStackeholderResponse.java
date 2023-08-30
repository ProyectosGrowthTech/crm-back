package org.crm.crmback.infrastructure.api.controllers.invoices.dto;

import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;

import java.util.List;

public record InvoicesStackeholderResponse(List<InvoicesStakeholder> invoicesItemList, Long totalItems) {}
