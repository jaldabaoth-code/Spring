package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcUpdate;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcUpdate.JdbcUpdateWizardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

/* Quest : JDBC Update */
@Controller
public class JdbcUpdateWizardController {
    private JdbcUpdateWizardRepository wizardRepository = new JdbcUpdateWizardRepository();

    /* Get all wizards */
    @GetMapping("/jdbc/update/wizards")
    public String getAll(Model model) {
        model.addAttribute("wizards", wizardRepository.findAll());
        return "/jdbc/jdbcUpdate/wizards";
    }

    @GetMapping("/jdbc/update/wizard")
    public String getById(Model model, @RequestParam Long id) {
        model.addAttribute("wizard", wizardRepository.findById(id));
        return "/jdbc/jdbcUpdate/wizard";
    }

    @PostMapping("/jdbc/update/wizard")
    public String update(Model model, @RequestParam Long id, @RequestParam String firstName,
                            @RequestParam String lastName, @RequestParam Date birthday, @RequestParam String birthPlace,
                            @RequestParam(required = false, defaultValue = "") String biography,
                            @RequestParam(required = false, defaultValue = "false") boolean muggle
    ) {
        model.addAttribute("wizard", wizardRepository.update(id, firstName, lastName, birthday, birthPlace, biography, muggle));
        return "/jdbc/jdbcUpdate/wizardUpdateResult";
    }
}
