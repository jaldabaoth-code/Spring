package com.wildcodeschool.wildandwizard.controller.jpa.jpaOneToMany;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.jpa.jpaOneToMany.JpaOneToManyWizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/* Quest : One To Many */
@Controller
public class JpaOneToManyWizardController {
    @Autowired
    private JpaOneToManyWizardRepository wizardRepository;

    /* Get all wizards */
    @GetMapping("/jpa/one-to-many/wizards")
    public String getAll(Model model) {
        model.addAttribute("wizards", wizardRepository.findAll());
        return "/jpa/jpaOneToMany/wizards";
    }

    /* Get Wizard by id */
    @GetMapping("/jpa/one-to-many/wizard")
    public String getWizard(Model model, @RequestParam(required = false) Long id) {
        Wizard wizard = new Wizard();
        if (id != null) {
            Optional<Wizard> optionalWizard = wizardRepository.findById(id);
            if (optionalWizard.isPresent()) {
                wizard = optionalWizard.get();
            }
        }
        model.addAttribute("wizard", wizard);
        return "/jpa/jpaOneToMany/wizard";
    }

    /* Create or Update a Wizard  */
    @PostMapping("/jpa/one-to-many/wizard")
    public String postWizard(@ModelAttribute Wizard wizard) {
        wizardRepository.save(wizard);
        return "redirect:/jpa/one-to-many/wizards";
    }

    /* Delete the Wizard */
    @GetMapping("/jpa/one-to-many/wizard/delete")
    public String deleteWizard(@RequestParam Long id) {
        wizardRepository.deleteById(id);
        return "redirect:/jpa/one-to-many/wizards";
    }
}
