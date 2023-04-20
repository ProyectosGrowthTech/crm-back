package org.crm.crmback.infrastructure.resources.dto;

public record TcgApiSetResponse(
    String id,
    String name,
    String series,
    Integer printedTotal,
    Integer total,
    TcgApiLegalitiesResponse legalities,
    String ptcgoCode,
    String releaseDate,
    String updatedAt,
    TcgApiImagesResponse images) {}
