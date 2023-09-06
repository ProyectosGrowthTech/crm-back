package org.crm.crmback.infrastructure.api.controllers.addresses.dto;

import javax.validation.constraints.Positive;

public record AddressRequest(
    @Positive Long addressId,
    String addressLine,
    String city,
    String postalCode,
    String country,
    String addressName,
    String state) {}
