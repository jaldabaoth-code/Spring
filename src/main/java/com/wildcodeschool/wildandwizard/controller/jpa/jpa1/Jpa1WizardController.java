package com.wildcodeschool.wildandwizard.controller.jpa.jpa1;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.jpa.JpaWizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/* JPA Quest : JPA 1 */
@Controller
public class Jpa1WizardController {
    @Autowired
    private JpaWizardRepository wizardRepository;

    /* Get all Wizards */
    @GetMapping("/jpa/jpa1/wizards")
    public String getAll(Model model) {
        model.addAttribute("wizards", wizardRepository.findAll());
        return "/jpa/jpa1/wizards";
    }

    /* Get Wizard by id */
    @GetMapping("/jpa/jpa1/wizard")
    public String getWizard(Model model, @RequestParam(required = false) Long id) {
        Wizard wizard = new Wizard();
        if (id != null) {
            Optional<Wizard> optionalWizard = wizardRepository.findById(id);
            if (optionalWizard.isPresent()) {
                wizard = optionalWizard.get();
            }
        }
        model.addAttribute("wizard", wizard);
        return "/jpa/jpa1/wizard";
    }

    /* Update new Wizard */
    @PostMapping("/jpa/jpa1/wizard")
    public String postWizard(@ModelAttribute Wizard wizard) {
        wizardRepository.save(wizard);
        return "redirect:/jpa/jpa1/wizards";
    }

    /* Delete the Wizard */
    @GetMapping("/jpa/jpa1/wizard/delete")
    public String deleteWizard(@RequestParam Long id) {
        wizardRepository.deleteById(id);
        return "redirect:/jpa/jpa1/wizards";
    }
}
