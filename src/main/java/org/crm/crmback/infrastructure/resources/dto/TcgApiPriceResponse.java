package org.crm.crmback.infrastructure.resources.dto;

import java.math.BigDecimal;

public record TcgApiPriceResponse(
    BigDecimal low, BigDecimal mid, BigDecimal high, BigDecimal market, BigDecimal directLow) {}
