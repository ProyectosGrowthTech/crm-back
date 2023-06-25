package org.crm.crmback.domain.service.address;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.addresses.Address;
import org.crm.crmback.infrastructure.addresses.facade.AddressPersistenceFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final AddressPersistenceFacade addressPersistenceFacade;

  @Override
  public Address createAddress(Address address) {
    return addressPersistenceFacade.save(address);
  }

  @Override
  public List<Address> getAddresses(Integer page, Integer pageSize) {
    return addressPersistenceFacade.getAddresses(page, pageSize);
  }

  @Override
  public Address getAddressById(Long id) {
    return addressPersistenceFacade.findById(id);
  }

  @Override
  public Address deleteAddressById(Long id) {
    return addressPersistenceFacade.deleteAddressById(id);
  }
}
