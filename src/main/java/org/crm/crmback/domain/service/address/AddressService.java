package org.crm.crmback.domain.service.address;

import java.util.List;
import org.crm.crmback.domain.model.addresses.Address;

public interface AddressService {

  Address createAddress(Address address);

  List<Address> getAddresses(Integer page, Integer pageSize);

  Address getAddressById(Long id);

  Address deleteAddressById(Long id);
}
