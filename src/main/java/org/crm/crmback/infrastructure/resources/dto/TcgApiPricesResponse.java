package org.crm.crmback.infrastructure.resources.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public record TcgApiPricesResponse(
    @JsonProperty("holofoil") TcgApiPriceResponse holoFoil,
    @JsonProperty("reverseHolofoil") TcgApiPriceResponse reverseHoloFoil,
    TcgApiPriceResponse normal,
    @JsonProperty("1stEditionHolofoil") TcgApiPriceResponse firstEditionHoloFoil,
    @JsonProperty("unlimitedHolofoil") TcgApiPriceResponse unlimitedHoloFoilResponse,
    BigDecimal averageSellPrice,
    BigDecimal lowPrice,
    BigDecimal trendPrice,
    BigDecimal reverseHoloSell,
    BigDecimal reverseHoloLow,
    BigDecimal reverseHoloTrend,
    BigDecimal lowPriceExPlus,
    BigDecimal avg1,
    BigDecimal avg7,
    BigDecimal avg30,
    BigDecimal reverseHoloAvg1,
    BigDecimal reverseHoloAvg7,
    BigDecimal reverseHoloAvg30) {}
