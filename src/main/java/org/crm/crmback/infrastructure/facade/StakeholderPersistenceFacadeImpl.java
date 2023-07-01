package org.crm.crmback.infrastructure.facade;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;
import org.crm.crmback.infrastructure.exception.ItemNotFoundException;
import org.crm.crmback.infrastructure.repository.stakeholder.StakeholderRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StakeholderPersistenceFacadeImpl implements StakeholderPersistenceFacade {

  private final StakeholderRepository stakeholderRepository;

  @Override
  public Stakeholder findById(Long id) {
    Stakeholder foundStakeholder =
        stakeholderRepository
            .findById(id)
            .orElseThrow(() -> new ItemNotFoundException("Stakeholder " + id + " not found"));
    return foundStakeholder;
  }

  @Override
  public Stakeholder save(Stakeholder newStakeholder) {
    return stakeholderRepository.save(newStakeholder);
  }

  @Override
  public List<Stakeholder> getStakeholders(Integer page, Integer pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize, Sort.by("Id").descending());
    List<Stakeholder> stakeholders = (List<Stakeholder>) stakeholderRepository.findAll(pageable);
    return stakeholders;
  }

  @Override
  public boolean isExistingStakeholder(Long id) {
    return stakeholderRepository.findById(id).isPresent();
  }

  @Override
  public Stakeholder deleteStakeholderById(Long id) {

    Stakeholder stakeholder = stakeholderRepository.findById(id).get();
    stakeholderRepository.delete(stakeholder);
    return stakeholder;
  }
}
