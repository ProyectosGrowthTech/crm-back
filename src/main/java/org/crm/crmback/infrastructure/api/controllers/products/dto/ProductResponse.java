package org.crm.crmback.infrastructure.api.controllers.products.dto;

import java.util.List;
import org.crm.crmback.domain.model.products.Product;

public record ProductResponse(List<Product> stakeholderList, Long totalProducts) {}
