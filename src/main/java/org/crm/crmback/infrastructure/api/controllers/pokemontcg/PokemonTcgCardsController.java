package org.crm.crmback.infrastructure.api.controllers.pokemontcg;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface PokemonTcgCardsController {

  @GetMapping(path = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> getCards();
}
