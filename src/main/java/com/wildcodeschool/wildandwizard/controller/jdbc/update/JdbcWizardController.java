package com.wildcodeschool.wildandwizard.controller.jdbc.update;

import com.wildcodeschool.wildandwizard.repository.jdbc.JDBCWizardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class JdbcWizardController {

    private JDBCWizardRepository repository = new JDBCWizardRepository();

    @GetMapping("/wizard/update")
    public String getWizardUpdate(Model model,
                                  @RequestParam Long id) {

        model.addAttribute("wizard", repository.findById(id));

        return "jdbc/update/wizard_update";
    }

    @PostMapping("/wizard/update")
    public String postWizardUpdate(Model model,
                             @RequestParam Long id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam Date birthday,
                             @RequestParam String birthPlace,
                             @RequestParam(required = false, defaultValue = "") String biography,
                             @RequestParam(required = false, defaultValue = "false") boolean muggle
    ) {
        model.addAttribute("wizard", repository.update(id, firstName, lastName,
                birthday, birthPlace, biography, muggle));

        return "jdbc/update/wizard_get";
    }
}
