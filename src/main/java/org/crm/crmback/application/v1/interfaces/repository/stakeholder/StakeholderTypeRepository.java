package org.crm.crmback.application.v1.interfaces.repository.stakeholder;

import java.util.List;
import org.crm.crmback.domain.model.stakeholders.StakeholderType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface StakeholderTypeRepository extends CrudRepository<StakeholderType, Long> {
  List<StakeholderType> findAll(Pageable pageable);
}
