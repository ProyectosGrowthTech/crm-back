package org.crm.crmback.infrastructure.resources.dto;

import java.util.List;

public record TcgApiCardsResponseBody(
    List<TcgApiDatumResponse> data, int page, int pageSize, int count, int totalCount) {}
