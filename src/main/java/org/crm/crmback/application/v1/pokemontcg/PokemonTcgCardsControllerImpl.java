package org.crm.crmback.application.v1.pokemontcg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.crm.crmback.domain.model.tcg.Card;
import org.crm.crmback.infrastructure.resources.facade.PokemonTcgApiFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PokemonTcgCardsControllerImpl implements PokemonTcgCardsController {

  private final PokemonTcgApiFacade apiFacade;

  @Override
  public ResponseEntity<Object> getCards() {
    List<Card> cardList = apiFacade.getCards(1, 10);
    ObjectMapper objectMapper = new ObjectMapper();
    String cardListJson;
    try {
      cardListJson = objectMapper.writeValueAsString(cardList);
    } catch (JsonProcessingException e) {
      return new ResponseEntity<>(
          "Error converting cardList to JSON", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return ResponseEntity.ok().body(cardListJson);
  }
}
