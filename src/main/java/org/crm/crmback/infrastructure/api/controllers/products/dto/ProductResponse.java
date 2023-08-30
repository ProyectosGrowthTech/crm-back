package org.crm.crmback.infrastructure.api.controllers.products.dto;

import org.crm.crmback.domain.model.products.Product;
import org.crm.crmback.domain.model.services.Service;

import java.util.List;

public record ProductResponse(List<Product> stakeholderList, Long totalProducts) {}
