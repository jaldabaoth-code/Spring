package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcUpdate;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcUpdate.JdbcUpdateSchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Quest : JDBC Update */
@Controller
public class JdbcUpdateSchoolController {
    private JdbcUpdateSchoolRepository schoolRepository = new JdbcUpdateSchoolRepository();

    /* Get all schools */
    @GetMapping("/jdbc/update/schools")
    public String getAll(Model model) {
        model.addAttribute("schools", schoolRepository.findAll());
        return "/jdbc/jdbcUpdate/schools";
    }

    @GetMapping("/jdbc/update/school")
    public String getById(Model model, @RequestParam Long id) {
        model.addAttribute("school", schoolRepository.findById(id));
        return "/jdbc/jdbcUpdate/school";
    }

    @PostMapping("/jdbc/update/school")
    public String update(Model model, @RequestParam Long id, @RequestParam String name, @RequestParam Long capacity, @RequestParam String country) {
        model.addAttribute("school", schoolRepository.update(id, name, capacity, country));
        return "/jdbc/jdbcUpdate/schoolUpdateResult";
    }
}
