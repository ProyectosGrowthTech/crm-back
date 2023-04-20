package org.crm.crmback.infrastructure.resources.dto;

import java.util.List;

public record TcgApiAttackResponse(
    String name, List<String> cost, int convertedEnergyCost, String damage, String text) {}
