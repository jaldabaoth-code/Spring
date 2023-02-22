package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcCrud;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcCrud.JdbcCrudWizardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JdbcCrudWizardController {

    private JdbcCrudWizardRepository wizardRepository = new JdbcCrudWizardRepository();

    @GetMapping("/jdbc/crud/wizards")
    public String getAll(Model model) {

        model.addAttribute("wizards", wizardRepository.findAll());

        return "/jdbc/jdbcCrud/wizards";
    }

    @GetMapping("/jdbc/crud/wizard")
    public String getWizard(Model model,
                            @RequestParam(required = false) Long id) {

        Wizard wizard = new Wizard();
        if (id != null) {
            wizard = wizardRepository.findById(id);
        }
        model.addAttribute("wizard", wizard);

        return "/jdbc/jdbcCrud/wizard";
    }

    @PostMapping("/jdbc/crud/wizard")
    public String postWizard(@ModelAttribute Wizard wizard) {

        if (wizard.getId() != null) {
            wizardRepository.update(wizard);
        } else {
            wizardRepository.save(wizard);
        }
        return "redirect:/jdbc/crud/wizards";
    }

    @GetMapping("/jdbc/crud/wizard/delete")
    public String deleteWizard(@RequestParam Long id) {

        wizardRepository.deleteById(id);

        return "redirect:/jdbc/crud/wizards";
    }
}