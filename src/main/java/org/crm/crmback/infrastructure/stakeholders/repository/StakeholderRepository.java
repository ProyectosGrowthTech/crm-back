package org.crm.crmback.infrastructure.stakeholders.repository;

import java.util.List;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface StakeholderRepository extends CrudRepository<Stakeholder, Long> {
  List<Stakeholder> findAll(Pageable pageable);
}
