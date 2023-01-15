package com.wildcodeschool.wildandwizard.controller.injection.injection1;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.injection.injection1.Injection1WizardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Quest : Injection 1 */
@Controller
public class Injection1WizardController {
    @Autowired
    private Injection1WizardDao wizardDao;

    @GetMapping("/injection/1/wizards")
    public String getAll(Model model) {
        model.addAttribute("wizards", wizardDao.findAll());
        return "/injection/injection1/wizards";
    }

    @GetMapping("/injection/1/wizard")
    public String getById(Model model, @RequestParam(required = false) Long id) {
        Wizard wizard = new Wizard();
        if (id != null) {
            wizard = wizardDao.findById(id);
        }
        model.addAttribute("wizard", wizard);
        return "/injection/injection1/wizard";
    }

    @PostMapping("/injection/1/wizard")
    public String save(@ModelAttribute Wizard wizard) {
        if (wizard.getId() != null) {
            wizardDao.update(wizard);
        } else {
            wizardDao.save(wizard);
        }
        return "redirect:/injection/1/wizards";
    }

    @GetMapping("/injection/1/wizard/delete")
    public String delete(@RequestParam Long id) {
        wizardDao.deleteById(id);
        return "redirect:/injection/1/wizards";
    }
}
