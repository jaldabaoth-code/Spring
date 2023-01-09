package com.wildcodeschool.wildandwizard.controller.jpa.jpaManyToMany;

import com.wildcodeschool.wildandwizard.entity.Race;
import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.jpa.jpaManyToMany.JpaManyToManyRaceRepository;
import com.wildcodeschool.wildandwizard.repository.jpa.jpaManyToMany.JpaManyToManyWizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* Quest : Many To Many */
@Controller
public class JpaManyToManyWizardController {
    @Autowired
    private JpaManyToManyWizardRepository wizardRepository;
    @Autowired
    private JpaManyToManyRaceRepository raceRepository;

    /* Get all wizards */
    @GetMapping("/jpa/many-to-many/wizards")
    public String getAll(Model model) {
        model.addAttribute("wizards", wizardRepository.findAll());
        return "/jpa/jpaManyToMany/wizards";
    }

    /* Get Wizard by id */
    @GetMapping("/jpa/many-to-many/wizard")
    public String getWizard(Model model, @RequestParam(required = false) Long id) {
        Wizard wizard = new Wizard();
        if (id != null) {
            Optional<Wizard> optionalWizard = wizardRepository.findById(id);
            if (optionalWizard.isPresent()) {
                wizard = optionalWizard.get();
            }
        }
        model.addAttribute("wizard", wizard);
        return "/jpa/jpaManyToMany/wizard";
    }

    /* Update new Wizard */
    @PostMapping("/jpa/many-to-many/wizard")
    public String postWizard(@ModelAttribute Wizard wizard) {
        wizardRepository.save(wizard);
        return "redirect:/jpa/many-to-many/wizards";
    }

    /* Delete the Wizard */
    @GetMapping("/jpa/many-to-many/wizard/delete")
    public String deleteWizard(@RequestParam Long id) {
        wizardRepository.deleteById(id);
        return "redirect:/jpa/many-to-many/wizards";
    }

    /* Show the races of wizard */
    @GetMapping("/jpa/many-to-many/wizard/races")
    public String getRaces(Model model, @RequestParam Long idWizard) {
        Optional<Wizard> optionalWizard = wizardRepository.findById(idWizard);
        Wizard wizard = new Wizard();
        if (optionalWizard.isPresent()) {
            wizard = optionalWizard.get();
        }
        model.addAttribute("wizard", wizard);
        model.addAttribute("allRaces", raceRepository.findAll());
        // Call the method getRaces in Wizard
        List<Race> races = new ArrayList<>();
        Method method = getMethod(wizard, "getRaces", new Class[]{});
        if (method != null) {
            try {
                races = (List<Race>) method.invoke(wizard);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("wizardRaces", races);
        return "/jpa/jpaManyToMany/wizardRace";
    }

    /* Register a wizard to the race */
    @PostMapping("/jpa/many-to-many/wizard/race")
    public String postRace(@RequestParam Long idWizard, @RequestParam Long idRace) {
        Optional<Wizard> optionalWizard = wizardRepository.findById(idWizard);
        if (optionalWizard.isPresent()) {
            Wizard wizard = optionalWizard.get();
            Optional<Race> optionalRace = raceRepository.findById(idRace);
            if (optionalRace.isPresent()) {
                Race race = optionalRace.get();
                // Call the method getRaces in Wizard
                List<Race> races;
                Method method = getMethod(wizard, "getRaces", new Class[]{});
                if (method != null) {
                    try {
                        races = (List<Race>) method.invoke(wizard);
                        races.add(race);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                wizardRepository.save(wizard);
            }
        }
        return "redirect:/jpa/many-to-many/wizard/races?idWizard=" + idWizard;
    }

    public Method getMethod(Object obj, String methodName, Class[] args) {
        Method method;
        try {
            method = obj.getClass().getDeclaredMethod(methodName, args);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
