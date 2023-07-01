package org.crm.crmback.infrastructure.repository.invoices;

import org.crm.crmback.domain.model.invoices.InvoicesStakeholderEntity;
import org.springframework.data.repository.CrudRepository;

public interface InvoicesStakeholderRepository
    extends CrudRepository<InvoicesStakeholderEntity, Long> {}
