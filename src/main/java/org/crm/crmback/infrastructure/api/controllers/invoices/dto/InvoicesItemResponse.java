package org.crm.crmback.infrastructure.api.controllers.invoices.dto;

import java.util.List;
import org.crm.crmback.domain.model.invoices.InvoicesItem;

public record InvoicesItemResponse(List<InvoicesItem> invoicesItemList, Long totalItems) {}
