package com.wildcodeschool.wildandwizard.controller.api.api1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildcodeschool.wildandwizard.model.api.api1.Api1People;
import com.wildcodeschool.wildandwizard.model.api.api1.Api1Planet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/* Quest : API */
@Controller
public class ApiSwapiController {
    private static final String SWAPI_URL = "https://swapi.dev";

    @GetMapping("/api/1/star-wars")
    public String starWars() {
        return "/api/api1/starWars";
    }

    /* Call the API and retrieve the planet */
    @GetMapping("/api/1/planet")
    public String planet(Model model, @RequestParam Long id) {
        Api1Planet planet = null;
        WebClient webClient = WebClient.create(SWAPI_URL);
        Mono<String> call = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/planets/{id}/").build(id))
                .retrieve()
                .bodyToMono(String.class);
        String response = call.block();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            planet = objectMapper.readValue(response, Api1Planet.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        model.addAttribute("planet", planet);
        return "/api/api1/planet";
    }

    /* Call the API and retrieve people */
    @GetMapping("/api/1/people")
    public String people(Model model, @RequestParam Long id) {
        WebClient webClient = WebClient.create(SWAPI_URL);
        Mono<String> call = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/people/{id}/").build(id))
                .retrieve()
                .bodyToMono(String.class);
        String response = call.block();
        ObjectMapper objectMapper = new ObjectMapper();
        Api1People people = null;
        try {
            people = objectMapper.readValue(response, Api1People.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        model.addAttribute("people", people);
        return "/api/api1/people";
    }
}
