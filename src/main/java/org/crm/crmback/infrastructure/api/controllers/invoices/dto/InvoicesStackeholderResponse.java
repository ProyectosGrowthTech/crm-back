package org.crm.crmback.infrastructure.api.controllers.invoices.dto;

import java.util.List;
import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;

public record InvoicesStackeholderResponse(
    List<InvoicesStakeholder> invoicesItemList, Long totalItems) {}
