package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcInjection;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInjection.WizardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Quest : JDBC Injection */
@Controller
public class JdbcInjectionWizardController {
    @Autowired
    private WizardDao wizardDao;

    @GetMapping("/jdbc/injection/wizards")
    public String getAll(Model model) {
        model.addAttribute("wizards", wizardDao.findAll());
        return "/jdbc/jdbcInjection/wizards";
    }

    @GetMapping("/jdbc/injection/wizard")
    public String getWizard(Model model, @RequestParam(required = false) Long id) {
        Wizard wizard = new Wizard();
        if (id != null) {
            wizard = wizardDao.findById(id);
        }
        model.addAttribute("wizard", wizard);
        return "/jdbc/jdbcInjection/wizard";
    }

    @PostMapping("/jdbc/injection/wizard")
    public String postWizard(@ModelAttribute Wizard wizard) {
        if (wizard.getId() != null) {
            wizardDao.update(wizard);
        } else {
            wizardDao.save(wizard);
        }
        return "redirect:/jdbc/injection/wizards";
    }

    @GetMapping("/jdbc/injection/wizard/delete")
    public String deleteWizard(@RequestParam Long id) {
        wizardDao.deleteById(id);
        return "redirect:/jdbc/injection/wizards";
    }
}