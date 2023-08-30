package org.crm.crmback.infrastructure.api.controllers.stakeholders.dto;

import javax.validation.constraints.Positive;

public record StakeholderRequest(
    @Positive Long stakeholderId,
    String name,
   String type,
   String identificationCode,
   String email,
   String phone,
    @Positive Long businessAddressId,
    @Positive Long taxAddressId){}

