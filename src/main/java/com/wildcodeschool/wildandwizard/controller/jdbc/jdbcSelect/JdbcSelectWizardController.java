package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcSelect;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcSelect.JdbcSelectWizardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Quest : JDBC Select */
@Controller
public class JdbcSelectWizardController {
    private JdbcSelectWizardRepository wizardRepository = new JdbcSelectWizardRepository();

    @GetMapping("/jdbc/select/wizards")
    public String getAll(Model model) {
        model.addAttribute("wizards", wizardRepository.findAll());
        return "/jdbc/jdbcSelect/wizards";
    }

    @GetMapping("/jdbc/select/wizard/id/search")
    public String getById(Model model, @RequestParam Long id) {
        model.addAttribute("wizard", wizardRepository.findById(id));
        return "/jdbc/jdbcSelect/wizardSearchByIdResult";
    }

    @GetMapping("/jdbc/select/wizards/last-name/search")
    public String getByLastName(Model model, @RequestParam String lastName) {
        model.addAttribute("wizards", wizardRepository.findByLastName(lastName));
        return "/jdbc/jdbcSelect/wizardsSearchByLastNameResult";
    }
}
