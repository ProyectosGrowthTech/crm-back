package org.crm.crmback.infrastructure.api.controllers.invoices.dto;

import org.crm.crmback.domain.model.invoices.InvoicesItem;

import java.util.List;

public record InvoicesItemResponse(List<InvoicesItem> invoicesItemList, Long totalItems) {}
