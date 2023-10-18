package org.crm.crmback.infrastructure.api.controllers.addresses;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.application.v1.service.address.AddressService;
import org.crm.crmback.domain.model.addresses.Address;
import org.crm.crmback.infrastructure.api.controllers.addresses.dto.AddressRequest;
import org.crm.crmback.infrastructure.api.controllers.addresses.dto.AddressResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/address")
public class AddressController {

  private final AddressService addressService;

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Address> createAddress(@RequestBody @Valid AddressRequest requestBody) {

    Address address =
        Address.builder()
            .addressLine(requestBody.addressLine())
            .city(requestBody.city())
            .postalCode(requestBody.postalCode())
            .country(requestBody.country())
            .addressName(requestBody.addressName())
            .state(requestBody.state())
            .build();
    Address resultAddress = addressService.createAddress(address);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultAddress);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AddressResponse> getAddresses(
      @RequestParam(name = "page", defaultValue = "0") @Positive Integer page,
      @RequestParam(name = "pageSize", defaultValue = "10") @Positive Integer pageSize) {

    AddressResponse resultAddresses = addressService.getAddresses(page, pageSize);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultAddresses);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(
      path = "/all",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AddressResponse> getAllAddresses() {

    AddressResponse resultAddresses = addressService.getAllAddresses();
    return ResponseEntity.status(HttpStatus.CREATED).body(resultAddresses);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(
      path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id) {

    Address resultAddress = addressService.getAddressById(id);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultAddress);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @DeleteMapping(
      path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteAddressById(@PathVariable("id") Long id) {
    try {
      addressService.deleteAddressById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
