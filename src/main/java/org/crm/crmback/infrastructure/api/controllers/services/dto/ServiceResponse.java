package org.crm.crmback.infrastructure.api.controllers.services.dto;

import org.crm.crmback.domain.model.services.Service;
import org.crm.crmback.domain.model.stakeholders.Stakeholder;

import java.util.List;

public record ServiceResponse(List<Service> stakeholderList, Long totalServices) {}
