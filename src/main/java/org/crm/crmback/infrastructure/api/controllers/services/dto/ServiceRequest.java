package org.crm.crmback.infrastructure.api.controllers.services.dto;

import org.crm.crmback.domain.model.services.ServiceType;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public record ServiceRequest(
        @Positive Long serviceId,
        @Positive Long serviceTypeId,
        String description,
        @Positive BigDecimal unitPrice){}

