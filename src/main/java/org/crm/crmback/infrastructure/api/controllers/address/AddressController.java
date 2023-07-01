package org.crm.crmback.infrastructure.api.controllers.address;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.application.v1.service.address.AddressService;
import org.crm.crmback.domain.model.addresses.Address;
import org.crm.crmback.infrastructure.api.controllers.address.dto.AddressRequest;
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

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Address> createAddress(@RequestBody @Valid AddressRequest requestBody) {

    Address address =
        Address.builder()
            .street(requestBody.street())
            .city(requestBody.city())
            .postalCode(requestBody.postalCode())
            .country(requestBody.country())
            .build();
    Address resultAddress = addressService.createAddress(address);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultAddress);
  }

  @GetMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Address>> getAddresses(
      @RequestParam(name = "page", defaultValue = "0") @Positive Integer page,
      @RequestParam(name = "pageSize", defaultValue = "10") @Positive Integer pageSize) {

    List<Address> resultInvoices = addressService.getAddresses(page, pageSize);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoices);
  }

  @GetMapping(
      path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id) {

    Address resultInvoice = addressService.getAddressById(id);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultInvoice);
  }

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
