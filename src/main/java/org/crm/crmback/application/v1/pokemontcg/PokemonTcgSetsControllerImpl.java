package org.crm.crmback.application.v1.pokemontcg;

import lombok.RequiredArgsConstructor;
import org.crm.crmback.infrastructure.resources.client.PokemonTcgClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PokemonTcgSetsControllerImpl implements PokemonTcgSetsController {

  private final PokemonTcgClient pokemonTcgClient;

  @Override
  public ResponseEntity<Object> getSets() {
    return pokemonTcgClient.getSets(1, 10);
  }
}
