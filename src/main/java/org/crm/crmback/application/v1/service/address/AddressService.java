package org.crm.crmback.application.v1.service.address;

import java.time.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.interfaces.repository.addresses.AddressRepository;
import org.crm.crmback.domain.model.addresses.Address;
import org.crm.crmback.infrastructure.api.controllers.addresses.dto.AddressResponse;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

  private final AddressRepository addressRepository;

  public Address createAddress(Address address) {
    LocalDateTime localDateTime = LocalDateTime.now();
    ZoneId serverTimeZone = ZoneId.systemDefault();
    ZonedDateTime serverDateTime = ZonedDateTime.of(localDateTime, serverTimeZone);

    Instant instant = serverDateTime.toInstant();

    address.setCreatedAt(Instant.now(Clock.systemDefaultZone()));
    address.setUpdatedAt(instant);
    return addressRepository.save(address);
  }

  public AddressResponse getAddresses(Integer page, Integer pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize, Sort.by("Id").descending());
    List<Address> addresses = addressRepository.findAll(pageable);
    long totalAddresses = addressRepository.count();
    AddressResponse addressResponse = new AddressResponse(addresses, totalAddresses);
    return addressResponse;
  }

  public AddressResponse getAllAddresses() {
    List<Address> addresses = (List<Address>) addressRepository.findAll();
    long totalAddresses = addressRepository.count();
    AddressResponse addressResponse = new AddressResponse(addresses, totalAddresses);
    return addressResponse;
  }

  public Address getAddressById(Long id) {
    Address foundAddress =
        addressRepository
            .findById(id)
            .orElseThrow(() -> new ItemNotFoundException("Address " + id + " not found"));
    return foundAddress;
  }

  public Address deleteAddressById(Long id) {
    Address address = addressRepository.findById(id).get();
    addressRepository.delete(address);
    return address;
  }
}
