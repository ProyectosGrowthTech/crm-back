package org.crm.crmback.infrastructure.resources.facade;

import java.util.List;
import org.crm.crmback.domain.model.tcg.Card;

public interface PokemonTcgApiFacade {

  List<Card> getCards(int page, int pageSize);
}
