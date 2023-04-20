package org.crm.crmback.domain.model.tcg;

public record Card(
    String id,
    String name,
    String level,
    String hp,
    Card evolvesFrom,
    Card evolvesTo,
    String ruleset,
    CardPricing cardPricing) {}
