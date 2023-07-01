package org.crm.crmback.infrastructure.facade.addresses;

import java.util.List;
import org.crm.crmback.domain.model.addresses.Address;

public interface AddressPersistenceFacade {
  Address findById(Long id);

  Address save(Address newInvoice);

  List<Address> getAddresses(Integer page, Integer pageSize);

  boolean isExistingAddress(Long id);

  Address deleteAddressById(Long id);
}
