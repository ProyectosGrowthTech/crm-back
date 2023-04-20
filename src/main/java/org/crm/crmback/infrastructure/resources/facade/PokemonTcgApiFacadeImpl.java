package org.crm.crmback.infrastructure.resources.facade;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crm.crmback.domain.model.tcg.Card;
import org.crm.crmback.infrastructure.resources.client.PokemonTcgClient;
import org.crm.crmback.infrastructure.resources.dto.TcgApiCardsResponseBody;
import org.crm.crmback.infrastructure.resources.dto.TcgApiDatumResponse;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PokemonTcgApiFacadeImpl implements PokemonTcgApiFacade {

  private final PokemonTcgClient httpClient;

  @Override
  // @Cacheable("cards")
  public List<Card> getCards(int page, int pageSize) {
    log.info("calling getCards endpoint from tcgApi");
    TcgApiCardsResponseBody response = httpClient.getCards(page, pageSize).getBody();
    List<Card> cards = new ArrayList<>();
    for (TcgApiDatumResponse cardData : response.data()) {
      Card card =
          new Card(
              cardData.id(),
              cardData.name(),
              cardData.level(),
              cardData.hp(),
              null,
              null,
              null,
              null);
      cards.add(card);
    }
    return cards;
  }
}
