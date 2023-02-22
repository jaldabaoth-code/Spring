package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcCrud;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcCrud.JdbcCrudSchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JdbcCrudSchoolController {

    private JdbcCrudSchoolRepository schoolRepository = new JdbcCrudSchoolRepository();

    @GetMapping("/jdbc/crud/schools")
    public String getAll(Model model) {

        model.addAttribute("schools", schoolRepository.findAll());

        return "/jdbc/jdbcCrud/schools";
    }

    @GetMapping("/jdbc/crud/school")
    public String getSchool(Model model,
                            @RequestParam(required = false) Long id) {

        School school = new School();
        if (id != null) {
            school = schoolRepository.findById(id);
        }
        model.addAttribute("school", school);

        return "/jdbc/jdbcCrud/school";
    }

    @PostMapping("/jdbc/crud/school")
    public String postSchool(@ModelAttribute School school) {

        if (school.getId() != null) {
            schoolRepository.update(school);
        } else {
            schoolRepository.save(school);
        }
        return "redirect:/jdbc/crud/schools";
    }

    @GetMapping("/jdbc/crud/school/delete")
    public String deleteSchool(@RequestParam Long id) {

        schoolRepository.deleteById(id);

        return "redirect:/jdbc/crud/schools";
    }
}
