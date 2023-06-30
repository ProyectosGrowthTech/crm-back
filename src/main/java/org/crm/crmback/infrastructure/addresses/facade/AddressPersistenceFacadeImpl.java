package org.crm.crmback.infrastructure.addresses.facade;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.addresses.Address;
import org.crm.crmback.infrastructure.addresses.repository.AddressRepository;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressPersistenceFacadeImpl implements AddressPersistenceFacade {

  private final AddressRepository addressRepository;

  @Override
  public Address findById(Long id) {
    Address foundAddress =
        addressRepository
            .findById(id)
            .orElseThrow(() -> new ItemNotFoundException("Address " + id + " not found"));
    return foundAddress;
  }

  @Override
  public Address save(Address newAddress) {
    return addressRepository.save(newAddress);
  }

  @Override
  public List<Address> getAddresses(Integer page, Integer pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize, Sort.by("Id").descending());
    List<Address> addresses = (List<Address>) addressRepository.findAll(pageable);
    return addresses;
  }

  @Override
  public boolean isExistingAddress(Long id) {
    return addressRepository.findById(id).isPresent();
  }

  @Override
  public Address deleteAddressById(Long id) {
    Address address = addressRepository.findById(id).get();
    addressRepository.delete(address);
    return address;
  }
}
