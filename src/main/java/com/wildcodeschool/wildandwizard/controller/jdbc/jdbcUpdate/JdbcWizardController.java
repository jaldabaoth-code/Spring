package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcUpdate;

import com.wildcodeschool.wildandwizard.repository.jdbc.JDBCWizardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

@Controller
public class JdbcWizardController {
    private JDBCWizardRepository wizardRepository = new JDBCWizardRepository();

    /* Get all wizards */
    @GetMapping("/jdbc/update/wizards")
    public String getAll(Model model) {
        // TODO : find all schools
        model.addAttribute("wizards", wizardRepository.findAll());
        return "jdbc/update/wizards";
    }

    @GetMapping("/wizard/update")
    public String getWizardUpdate(Model model, @RequestParam Long id) {
        model.addAttribute("wizard", wizardRepository.findById(id));
        return "wizard";
    }

    @PostMapping("/wizard/update")
    public String postWizardUpdate(Model model, @RequestParam Long id, @RequestParam String firstName,
                            @RequestParam String lastName, @RequestParam Date birthday, @RequestParam String birthPlace,
                            @RequestParam(required = false, defaultValue = "") String biography,
                            @RequestParam(required = false, defaultValue = "false") boolean muggle
    ) {
        model.addAttribute("wizard", wizardRepository.update(id, firstName, lastName, birthday, birthPlace, biography, muggle));
        return "jdbc/update/wizard_get";
    }
}
