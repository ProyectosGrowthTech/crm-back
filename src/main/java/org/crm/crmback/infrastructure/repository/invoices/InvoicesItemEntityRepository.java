package org.crm.crmback.infrastructure.repository.invoices;

import org.crm.crmback.domain.model.invoices.InvoicesItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface InvoicesItemEntityRepository extends CrudRepository<InvoicesItemEntity, Long> {}
