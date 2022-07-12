package com.wildcodeschool.wildandwizard.controller.jpa;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/* Spring Quests : JPA (Wizard) */
@Controller
public class WizardController {
    @Autowired
    private WizardRepository repository;

    @GetMapping("/jpa")
    public String jpa() {
        return "jpa/jpa";
    }

    /* Spring Quest : JPA (Get all Wizards) */
    @GetMapping("/jpa/wizards")
    public String getAll(Model model) {
        model.addAttribute("wizards", repository.findAll());
        return "/jpa/wizards";
    }

    /* Spring Quest : JPA (Get Wizard by id) */
    @GetMapping("/jpa/wizard")
    public String getWizard(Model model,  @RequestParam(required = false) Long id) {
        Wizard wizard = new Wizard();
        if (id != null) {
            Optional<Wizard> optionalWizard = repository.findById(id);
            if (optionalWizard.isPresent()) {
                wizard = optionalWizard.get();
            }
        }
        model.addAttribute("wizard", wizard);
        return "/jpa/wizard";
    }

    /* Spring Quest : JPA (Update new Wizard) */
    @PostMapping("/jpa/wizard")
    public String postWizard(@ModelAttribute Wizard wizard) {
        repository.save(wizard);
        return "redirect:/jpa/wizards";
    }

    /* Spring Quest : JPA (Delete the Wizard) */
    @GetMapping("/jpa/wizard/delete")
    public String deleteWizard(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/jpa/wizards";
    }
}
