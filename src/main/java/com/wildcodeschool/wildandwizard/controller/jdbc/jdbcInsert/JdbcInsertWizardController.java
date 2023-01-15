package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcInsert;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInsert.JdbcInsertWizardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

@Controller
public class JdbcInsertWizardController {
    private JdbcInsertWizardRepository repository = new JdbcInsertWizardRepository();

    @PostMapping("/jdbc/insert/wizard")
    public String create(Model model, @RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam Date birthday, @RequestParam String birthPlace,
                                @RequestParam(required = false, defaultValue = "") String biography,
                                @RequestParam(required = false, defaultValue = "false") boolean muggle
    ) {
        model.addAttribute("wizard", repository.save(firstName, lastName, birthday, birthPlace, biography, muggle));
        return "/jdbc/jdbcInsert/wizardInsertResult";
    }
}
