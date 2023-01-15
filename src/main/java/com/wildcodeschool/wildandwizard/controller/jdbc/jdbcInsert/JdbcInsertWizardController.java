package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcInsert;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInsert.JdbcInsertWizardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

/* Quest : JDBC Insert */
@Controller
public class JdbcInsertWizardController {
    private JdbcInsertWizardRepository wizardRepository = new JdbcInsertWizardRepository();

    @GetMapping("/jdbc/insert/wizard")
    public String createForm() {
        return "/jdbc/jdbcInsert/wizard";
    }

    @PostMapping("/jdbc/insert/wizard")
    public String insert(Model model, @RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam Date birthday, @RequestParam String birthPlace,
                                @RequestParam(required = false, defaultValue = "") String biography,
                                @RequestParam(required = false, defaultValue = "false") boolean muggle
    ) {
        model.addAttribute("wizard", wizardRepository.save(firstName, lastName, birthday, birthPlace, biography, muggle));
        return "/jdbc/jdbcInsert/wizardInsertResult";
    }
}
