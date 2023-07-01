package org.crm.crmback.infrastructure.api.controllers.address.dto;

import javax.validation.constraints.Positive;

public record AddressRequest(
    @Positive Long addressId, String street, String city, String postalCode, String country) {}
