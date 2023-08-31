package org.crm.crmback.infrastructure.api.controllers.addresses.dto;

import java.util.List;
import org.crm.crmback.domain.model.addresses.Address;

public record AddressResponse(List<Address> addressList, Long totalAddresses) {}
