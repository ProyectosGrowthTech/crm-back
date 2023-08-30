package org.crm.crmback.application.v1.interfaces.repository.invoices;

import org.crm.crmback.domain.model.invoices.Invoice;
import org.crm.crmback.domain.model.invoices.InvoicesStakeholder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoicesStakeholderRepository extends CrudRepository<InvoicesStakeholder, Long> {
  List<InvoicesStakeholder> findAll(Pageable pageable);
}
