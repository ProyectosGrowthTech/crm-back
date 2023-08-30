package org.crm.crmback.infrastructure.api.controllers.addresses.dto;

import org.crm.crmback.domain.model.addresses.Address;

import java.util.List;

public record AddressResponse(List<Address> addressList, Long totalAddresses) {}
