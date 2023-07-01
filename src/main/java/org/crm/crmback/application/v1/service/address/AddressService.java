package org.crm.crmback.application.v1.service.address;

import java.time.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.addresses.Address;
import org.crm.crmback.infrastructure.facade.addresses.AddressPersistenceFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

  private final AddressPersistenceFacade addressPersistenceFacade;

  public Address createAddress(Address address) {
    LocalDateTime localDateTime = LocalDateTime.now();
    ZoneId serverTimeZone = ZoneId.systemDefault();
    ZonedDateTime serverDateTime = ZonedDateTime.of(localDateTime, serverTimeZone);

    Instant instant = serverDateTime.toInstant();

    address.setCreatedAt(Instant.now(Clock.systemDefaultZone()));
    address.setUpdatedAt(instant);
    return addressPersistenceFacade.save(address);
  }

  public List<Address> getAddresses(Integer page, Integer pageSize) {
    return addressPersistenceFacade.getAddresses(page, pageSize);
  }

  public Address getAddressById(Long id) {
    return addressPersistenceFacade.findById(id);
  }

  public Address deleteAddressById(Long id) {
    return addressPersistenceFacade.deleteAddressById(id);
  }
}
