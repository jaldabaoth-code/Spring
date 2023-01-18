package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcDelete;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcDelete.JdbcDeleteSchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Quest : JDBC Delete */
@Controller
public class JdbcDeleteSchoolController {
    private JdbcDeleteSchoolRepository schoolRepository = new JdbcDeleteSchoolRepository();

    @GetMapping("/jdbc/delete/school/delete")
    public String delete(@RequestParam Long id) {
        schoolRepository.deleteById(id);
        return "redirect:/jdbc/delete/schools";
    }

    @GetMapping("/jdbc/delete/schools")
    public String getAll(Model model) {
        model.addAttribute("schools", schoolRepository.findAll());
        return "/jdbc/jdbcDelete/schools";
    }
}
