package org.crm.crmback.application.v1.interfaces.repository.invoices;

import java.util.List;
import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface InvoicesStakeholderRepository extends CrudRepository<InvoicesStakeholder, Long> {
  List<InvoicesStakeholder> findAll(Pageable pageable);
}
