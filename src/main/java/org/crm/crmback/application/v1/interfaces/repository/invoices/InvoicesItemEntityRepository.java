package org.crm.crmback.application.v1.interfaces.repository.invoices;

import org.crm.crmback.domain.model.invoices.InvoicesItem;
import org.springframework.data.repository.CrudRepository;

public interface InvoicesItemEntityRepository extends CrudRepository<InvoicesItem, Long> {}
