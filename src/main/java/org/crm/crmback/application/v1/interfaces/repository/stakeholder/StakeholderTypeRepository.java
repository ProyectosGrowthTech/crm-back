package org.crm.crmback.application.v1.interfaces.repository.stakeholder;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.stakeholders.StakeholderType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StakeholderTypeRepository extends CrudRepository<StakeholderType, Long> {
  List<StakeholderType> findAll(Pageable pageable);
}
