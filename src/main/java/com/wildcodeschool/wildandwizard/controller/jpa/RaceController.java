package com.wildcodeschool.wildandwizard.controller.jpa;

import com.wildcodeschool.wildandwizard.entity.Race;
import com.wildcodeschool.wildandwizard.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/* Spring Quests : JPA (Race) */
@Controller
public class RaceController {
    @Autowired
    private RaceRepository raceRepository;

    /* Spring Quest : JPA Many To Many (Get all Races) */
    @GetMapping("/jpa/races")
    public String getAll(Model model) {
        // TODO : find all races
        model.addAttribute("races", raceRepository.findAll());
        return "/jpa/races";
    }

    /* Spring Quest : JPA Many To Many (Get Race by id) */
    @GetMapping("/jpa/race")
    public String getRace(Model model, @RequestParam(required = false) Long id) {
        // TODO : find one race by id
        Race race = new Race();
        if (id != null) {
            Optional<Race> optionalRace = raceRepository.findById(id);
            if (optionalRace.isPresent()) {
                race = optionalRace.get();
            }
        }
        model.addAttribute("race", race);
        return "/jpa/race";
    }

    /* Spring Quest : JPA Many To Many (Update new Race) */
    @PostMapping("/jpa/race")
    public String postRace(@ModelAttribute Race race) {
        // TODO : create or update a race
        raceRepository.save(race);
        return "redirect:/jpa/races";
    }

    /* Spring Quest : JPA Many To Many (Delete the Race) */
    @GetMapping("/jpa/race/delete")
    public String deleteRace(@RequestParam Long id) {
        // TODO : delete a race
        raceRepository.deleteById(id);
        return "redirect:/jpa/races";
    }
}
