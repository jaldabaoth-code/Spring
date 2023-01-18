package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcDelete;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcDelete.JdbcDeleteWizardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Quest : JDBC Delete */
@Controller
public class JdbcDeleteWizardController {
    private JdbcDeleteWizardRepository wizardRepository = new JdbcDeleteWizardRepository();

    @GetMapping("/jdbc/delete/wizard/delete")
    public String delete(@RequestParam Long id) {
        wizardRepository.deleteById(id);
        return "redirect:/jdbc/delete/wizards";
    }

    @GetMapping("/jdbc/delete/wizards")
    public String getAll(Model model) {
        model.addAttribute("wizards", wizardRepository.findAll());
        return "/jdbc/jdbcDelete/wizards";
    }
}
