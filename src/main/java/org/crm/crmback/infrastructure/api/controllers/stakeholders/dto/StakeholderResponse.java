package org.crm.crmback.infrastructure.api.controllers.stakeholders.dto;

import java.util.List;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;

public record StakeholderResponse(List<Stakeholder> stakeholderList, Long totalStakeholders) {}
