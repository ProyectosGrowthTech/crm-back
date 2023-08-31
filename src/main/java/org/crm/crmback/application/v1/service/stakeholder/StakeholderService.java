package org.crm.crmback.application.v1.service.stakeholder;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.interfaces.repository.stakeholder.StakeholderRepository;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;
import org.crm.crmback.infrastructure.api.controllers.stakeholders.dto.StakeholderResponse;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StakeholderService {

  private final StakeholderRepository stakeholderRepository;

  public Stakeholder createStakeholder(Stakeholder stakeholder) {
    // TODO: Implement logic business to check if stakeholder already exists, that customer exists,
    // etc.
    return stakeholderRepository.save(stakeholder);
  }

  public StakeholderResponse getStakeholders(Integer page, Integer pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize, Sort.by("Id").descending());
    List<Stakeholder> stakeholders = stakeholderRepository.findAll(pageable);
    long totalStakeholders = stakeholderRepository.count();
    StakeholderResponse stakeholderResponse =
        new StakeholderResponse(stakeholders, totalStakeholders);
    return stakeholderResponse;
  }

  public Stakeholder getStakeholderById(Long id) {
    Stakeholder foundStakeholder =
        stakeholderRepository
            .findById(id)
            .orElseThrow(() -> new ItemNotFoundException("Invoice " + id + " not found"));
    return foundStakeholder;
  }

  public Stakeholder deleteStakeholderById(Long id) {
    Stakeholder stakeholder = stakeholderRepository.findById(id).get();
    stakeholderRepository.delete(stakeholder);
    return stakeholder;
  }
}
