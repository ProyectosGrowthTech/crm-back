package org.crm.crmback.application.v1.interfaces.repository.addresses;

import java.util.List;
import org.crm.crmback.domain.model.addresses.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
  List<Address> findAll(Pageable pageable);
}
