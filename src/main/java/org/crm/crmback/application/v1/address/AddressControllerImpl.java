package org.crm.crmback.application.v1.address;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.application.v1.address.dto.AddressRequest;
import org.crm.crmback.domain.model.addresses.Address;
import org.crm.crmback.domain.service.address.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AddressControllerImpl implements AddressController {

  private final AddressService addressService;

  @Override
  public ResponseEntity<Address> createAddress(@Valid AddressRequest requestBody) {
    Address address =
        new Address(
            requestBody.street(),
            requestBody.city(),
            requestBody.postalCode(),
            requestBody.country());
    Address resultAddress = addressService.createAddress(address);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultAddress);
  }

  @Override
  public ResponseEntity<List<Address>> getAddresses(
      @PositiveOrZero Integer page, @Positive Integer pageSize) {

    List<Address> resultInvoices = addressService.getAddresses(page, pageSize);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoices);
  }

  @Override
  public ResponseEntity<Address> getAddressById(Long id) {

    Address resultInvoice = addressService.getAddressById(id);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }

  @Override
  public ResponseEntity<Void> deleteAddressById(Long id) {
    try {
      addressService.deleteAddressById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
