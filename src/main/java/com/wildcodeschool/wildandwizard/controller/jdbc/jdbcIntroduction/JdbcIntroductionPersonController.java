package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcIntroduction;

import com.wildcodeschool.wildandwizard.entity.Person;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcIntroduction.JdbcIntroductionPersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Quest : JDBC Introduction */
@Controller
public class JdbcIntroductionPersonController {
    private JdbcIntroductionPersonRepository repository = new JdbcIntroductionPersonRepository();

    @GetMapping("/jdbc/introduction/persons")
    public String getAll(Model model) {
        model.addAttribute("persons", repository.findAll());
        return "jdbc/jdbcIntroduction/persons";
    }

    @GetMapping("/jdbc/introduction/person")
    public String getPerson(Model model, @RequestParam(required = false) Long id) {
        Person person = new Person();
        if (id != null) {
            person = repository.findById(id);
        }
        model.addAttribute("person", person);
        return "jdbc/jdbcIntroduction/person";
    }

    @PostMapping("/jdbc/introduction/person")
    public String postPerson(@ModelAttribute Person person) {
        if (person.getId() != null) {
            repository.update(person);
        } else {
            repository.save(person);
        }
        return "redirect:/jdbc/jdbcIntroduction/persons";
    }

    @GetMapping("/jdbc/introduction/person/delete")
    public String deletePerson(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/jdbc/jdbcIntroduction/persons";
    }
}
