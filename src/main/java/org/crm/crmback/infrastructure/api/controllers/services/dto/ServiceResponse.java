package org.crm.crmback.infrastructure.api.controllers.services.dto;

import java.util.List;
import org.crm.crmback.domain.model.services.Service;

public record ServiceResponse(List<Service> stakeholderList, Long totalServices) {}
