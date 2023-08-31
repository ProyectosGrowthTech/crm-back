package org.crm.crmback.infrastructure.api.controllers.services.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Positive;

public record ServiceRequest(
    @Positive Long serviceId,
    @Positive Long serviceTypeId,
    String description,
    @Positive BigDecimal unitPrice) {}
