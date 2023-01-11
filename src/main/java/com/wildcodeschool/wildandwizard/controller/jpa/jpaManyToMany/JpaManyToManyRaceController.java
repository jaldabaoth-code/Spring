package com.wildcodeschool.wildandwizard.controller.jpa.jpaManyToMany;

import com.wildcodeschool.wildandwizard.entity.Race;
import com.wildcodeschool.wildandwizard.repository.jpa.jpaManyToMany.JpaManyToManyRaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/* Quest : Many To Many */
@Controller
public class JpaManyToManyRaceController {
    @Autowired
    private JpaManyToManyRaceRepository raceRepository;

    /* Get all Races */
    @GetMapping("/jpa/many-to-many/races")
    public String getAll(Model model) {
        model.addAttribute("races", raceRepository.findAll());
        return "/jpa/jpaManyToMany/races";
    }

    /* Get Race by id */
    @GetMapping("/jpa/many-to-many/race")
    public String getRace(Model model, @RequestParam(required = false) Long id) {
        Race race = new Race();
        if (id != null) {
            Optional<Race> optionalRace = raceRepository.findById(id);
            if (optionalRace.isPresent()) {
                race = optionalRace.get();
            }
        }
        model.addAttribute("race", race);
        return "/jpa/jpaManyToMany/race";
    }

    /* Update new Race */
    @PostMapping("/jpa/many-to-many/race")
    public String postRace(@ModelAttribute Race race) {
        raceRepository.save(race);
        return "redirect:/jpa/many-to-many/races";
    }

    /* Delete the Race */
    @GetMapping("/jpa/many-to-many/race/delete")
    public String deleteRace(@RequestParam Long id) {
        raceRepository.deleteById(id);
        return "redirect:/jpa/many-to-many/races";
    }
}