package org.crm.crmback.infrastructure.resources.dto;

public record TcgApiCardMarketResponse(String url, String updatedAt, TcgApiPricesResponse prices) {}
