package com.wildcodeschool.wildandwizard.controller.jdbc.update;

import com.wildcodeschool.wildandwizard.repository.jdbc.JDBCSchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JdbcSchoolController {
    private JDBCSchoolRepository schoolRepository = new JDBCSchoolRepository();

    /* Get all wizards */
    @GetMapping("/jdbc/update/schools")
    public String getAll(Model model) {
        // TODO : find all schools
        model.addAttribute("wizards", schoolRepository.findAll());
        return "jdbc/update/schools";
    }

    @GetMapping("/jdbc/update/school/update")
    public String getSchoolUpdate(Model model, @RequestParam Long id) {
        model.addAttribute("school", schoolRepository.findById(id));
        return "school";
    }


    @GetMapping("/jdbc/update/index")
    public String postIndex() {
        return "jdbc/update/index";
    }

    @PostMapping("/jdbc/school/update")
    public String postSchoolUpdate(Model model, @RequestParam Long id, @RequestParam String name, @RequestParam Long capacity, @RequestParam String country) {
        model.addAttribute("school", schoolRepository.update(id, name, capacity, country));
        return "jdbc/update/school_get";
    }
}
