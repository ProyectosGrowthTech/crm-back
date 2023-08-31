package org.crm.crmback.infrastructure.api.controllers.services;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.application.v1.service.address.AddressService;
import org.crm.crmback.application.v1.service.stakeholder.StakeholderService;
import org.crm.crmback.domain.model.addresses.Address;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;
import org.crm.crmback.infrastructure.api.controllers.stakeholders.dto.StakeholderRequest;
import org.crm.crmback.infrastructure.api.controllers.stakeholders.dto.StakeholderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/service")
public class ServiceController {

  private final AddressService addressService;
  private final StakeholderService stakeholderService;

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Stakeholder> createStakeholder(
      @RequestBody @Valid StakeholderRequest requestBody) {

    Address bussinessAddress = addressService.getAddressById(requestBody.businessAddressId());
    Address taxAddress = addressService.getAddressById(requestBody.taxAddressId());

    Stakeholder stakeholder =
        Stakeholder.builder()
            .name(requestBody.name())
            .type(requestBody.type())
            .identificationCode(requestBody.identificationCode())
            .email(requestBody.email())
            .phone(requestBody.phone())
            .businessAddress(bussinessAddress)
            .taxAddress(taxAddress)
            .build();

    Stakeholder resultStakeholder = stakeholderService.createStakeholder(stakeholder);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultStakeholder);
  }

  @GetMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StakeholderResponse> getStakeholders(
      @RequestParam(name = "page", defaultValue = "0") @Positive Integer page,
      @RequestParam(name = "pageSize", defaultValue = "10") @Positive Integer pageSize) {

    StakeholderResponse resultStakeholders = stakeholderService.getStakeholders(page, pageSize);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultStakeholders);
  }

  @GetMapping(
      path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Stakeholder> getStakeholderById(@PathVariable("id") Long id) {

    Stakeholder resultStakeholder = stakeholderService.getStakeholderById(id);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultStakeholder);
  }

  @DeleteMapping(
      path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteStakeholderById(@PathVariable("id") Long id) {
    try {
      stakeholderService.deleteStakeholderById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
