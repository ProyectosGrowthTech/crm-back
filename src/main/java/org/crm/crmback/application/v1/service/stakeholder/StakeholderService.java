package org.crm.crmback.application.v1.service.stakeholder;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.application.v1.interfaces.facade.stakeholder.StakeholderPersistenceFacade;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StakeholderService {

  private final StakeholderPersistenceFacade stakeholderPersistenceFacade;

  public Stakeholder createStakeholder(Stakeholder stakeholder) {
    // TODO: Implement logic business to check if stakeholder already exists, that customer exists,
    // etc.
    return stakeholderPersistenceFacade.save(stakeholder);
  }

  // public InvoiceResponse getInvoices(Integer page, Integer pageSize) {
  // return stakeholderPersistenceFacade.getInvoices(page, pageSize);
  // }

  public Stakeholder getStakeholderById(Long id) {
    return stakeholderPersistenceFacade.findById(id);
  }

  public List<Stakeholder> getStakeholdersById(List<Long> ids) {

    List<Stakeholder> stakeholders = new ArrayList<>();
    for (Long id : ids) {
      stakeholders.add(stakeholderPersistenceFacade.findById(id));
    }
    return stakeholders;
  }

  public Stakeholder deleteStakeholderById(Long id) {
    return stakeholderPersistenceFacade.deleteStakeholderById(id);
  }
}
