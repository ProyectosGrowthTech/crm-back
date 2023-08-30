package org.crm.crmback.infrastructure.api.controllers.stakeholders.dto;

import org.crm.crmback.domain.model.stakeholders.Stakeholder;

import java.util.List;

public record StakeholderResponse(List<Stakeholder> stakeholderList, Long totalStakeholders) {}
