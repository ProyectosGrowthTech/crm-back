package org.crm.crmback.infrastructure.facade;

import java.util.List;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;

public interface StakeholderPersistenceFacade {

  Stakeholder findById(Long id);

  Stakeholder save(Stakeholder newStakeholder);

  List<Stakeholder> getStakeholders(Integer page, Integer pageSize);

  boolean isExistingStakeholder(Long id);

  Stakeholder deleteStakeholderById(Long id);
}
