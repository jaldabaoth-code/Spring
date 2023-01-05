package com.wildcodeschool.wildandwizard.controller.jpa.manyToMany;

import com.wildcodeschool.wildandwizard.entity.Race;
import com.wildcodeschool.wildandwizard.repository.jpa.JpaRaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/* JPA Quest : Many To Many */
@Controller
public class ManyToManyRaceController {
    @Autowired
    private JpaRaceRepository raceRepository;

    /* Get all Races */
    @GetMapping("/jpa/many-to-many/races")
    public String getAll(Model model) {
        // TODO : find all races
        model.addAttribute("races", raceRepository.findAll());
        return "/jpa/manyToMany/races";
    }

    /* Get Race by id */
    @GetMapping("/jpa/many-to-many/race")
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
        return "/jpa/manyToMany/race";
    }

    /* Update new Race */
    @PostMapping("/jpa/many-to-many/race")
    public String postRace(@ModelAttribute Race race) {
        // TODO : create or update a race
        raceRepository.save(race);
        return "redirect:/jpa/many-to-many/races";
    }

    /* Delete the Race */
    @GetMapping("/jpa/many-to-many/race/delete")
    public String deleteRace(@RequestParam Long id) {
        // TODO : delete a race
        raceRepository.deleteById(id);
        return "redirect:/jpa/many-to-many/races";
    }
}
