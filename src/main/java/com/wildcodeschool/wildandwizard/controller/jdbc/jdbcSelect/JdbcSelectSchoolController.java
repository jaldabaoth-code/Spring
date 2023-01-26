package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcSelect;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcSelect.JdbcSelectSchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Quest : JDBC Select */
@Controller
public class JdbcSelectSchoolController {
    private JdbcSelectSchoolRepository schoolRepository = new JdbcSelectSchoolRepository();

    @GetMapping("/jdbc/select/schools")
    public String getAll(Model model) {
        model.addAttribute("schools", schoolRepository.findAll());
        return "/jdbc/jdbcSelect/schools";
    }

    @GetMapping("/jdbc/select/school")
    public String getById(Model model, @RequestParam Long id) {
        model.addAttribute("school", schoolRepository.findById(id));
        return "/jdbc/jdbcSelect/school";
    }

    @GetMapping("/jdbc/select/schools/search")
    public String getByCountry(Model model, @RequestParam String country) {
        model.addAttribute("schools", schoolRepository.findByCountry(country));
        return "/jdbc/jdbcSelect/schools";
    }
}
