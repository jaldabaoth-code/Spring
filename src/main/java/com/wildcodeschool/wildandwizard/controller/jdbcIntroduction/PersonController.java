package com.wildcodeschool.wildandwizard.controller.jdbcIntroduction;

import com.wildcodeschool.wildandwizard.entity.Person;
import com.wildcodeschool.wildandwizard.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
    private PersonRepository repository = new PersonRepository();

    @GetMapping("/persons")
    public String getAll(Model model) {
        model.addAttribute("persons", repository.findAll());
        return "jdbcIntroduction/persons";
    }

    @GetMapping("/person")
    public String getPerson(Model model, @RequestParam(required = false) Long id) {
        Person person = new Person();
        if (id != null) {
            person = repository.findById(id);
        }
        model.addAttribute("person", person);
        return "jdbcIntroduction/person";
    }

    @PostMapping("/person")
    public String postPerson(@ModelAttribute Person person) {
        if (person.getId() != null) {
            repository.update(person);
        } else {
            repository.save(person);
        }
        return "redirect:/persons";
    }

    @GetMapping("/person/delete")
    public String deletePerson(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/persons";
    }
}
