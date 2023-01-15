package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcInsert;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInsert.JdbcInsertSchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JdbcInsertSchoolController {
    private JdbcInsertSchoolRepository repository = new JdbcInsertSchoolRepository();

    @PostMapping("/jdbc/insert/school/create")
    public String create(Model model, @RequestParam String name, @RequestParam Long capacity, @RequestParam String country) {
        System.out.println(name);
        model.addAttribute("school", repository.save(name, capacity, country));
        return "/jdbc/jdbcInsert/schoolInsertResult";
    }
}
