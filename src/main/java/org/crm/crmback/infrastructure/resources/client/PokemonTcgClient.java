package org.crm.crmback.infrastructure.resources.client;

import org.crm.crmback.infrastructure.configuration.FeignConfiguration;
import org.crm.crmback.infrastructure.resources.dto.TcgApiCardsResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "pokemonTcgClient",
    url = "${application.third-party-apis.pokemon-tcg.base-url}",
    configuration = FeignConfiguration.class)
public interface PokemonTcgClient {

  @GetMapping("${application.third-party-apis.pokemon-tcg.endpoints.sets}")
  ResponseEntity<Object> getSets(
      @RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize);

  @GetMapping("${application.third-party-apis.pokemon-tcg.endpoints.cards}")
  ResponseEntity<TcgApiCardsResponseBody> getCards(
      @RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize);
}
