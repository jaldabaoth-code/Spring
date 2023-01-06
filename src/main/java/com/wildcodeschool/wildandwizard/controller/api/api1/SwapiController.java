package com.wildcodeschool.wildandwizard.controller.api.api1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildcodeschool.wildandwizard.model.People;
import com.wildcodeschool.wildandwizard.model.Planet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/* API Quest : API */
@Controller
public class SwapiController {
    private static final String SWAPI_URL = "https://swapi.dev";

    @GetMapping("/api/api1/star-wars")
    public String starWars() {
        return "api/api1/starWars";
    }

    /* Spring Quest : API (Star Wars - Planet) */
    @GetMapping("/api/planet")
    public String planet(Model model, @RequestParam Long id) {
        Planet planetObject = null;
        // TODO : call the API and retrieve the planet
        WebClient webClient = WebClient.create(SWAPI_URL);
        Mono<String> call = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/planets/{id}/")
                        .build(id))
                .retrieve()
                .bodyToMono(String.class);
        String response = call.block();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            planetObject = objectMapper.readValue(response, Planet.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        model.addAttribute("planetInfos", planetObject);
        return "api/api1/planet";
    }

    /* Spring Quest : API (Star Wars - People) */
    @GetMapping("/api/people")
    public String people(Model model, @RequestParam Long id) {
        WebClient webClient = WebClient.create(SWAPI_URL);
        Mono<String> call = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/people/{id}/")
                        .build(id))
                .retrieve()
                .bodyToMono(String.class);
        String response = call.block();
        ObjectMapper objectMapper = new ObjectMapper();
        People peopleObject = null;
        try {
            peopleObject = objectMapper.readValue(response, People.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        model.addAttribute("peopleInfos", peopleObject);
        return "api/api1/people";
    }
}
