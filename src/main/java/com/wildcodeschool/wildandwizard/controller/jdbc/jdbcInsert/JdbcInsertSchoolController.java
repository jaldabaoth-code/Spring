package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcInsert;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInsert.JdbcInsertSchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Quest : JDBC Insert */
@Controller
public class JdbcInsertSchoolController {
    private JdbcInsertSchoolRepository repository = new JdbcInsertSchoolRepository();

    @GetMapping("/jdbc/insert/school")
    public String createForm() {
        return "/jdbc/jdbcInsert/school";
    }

    @PostMapping("/jdbc/insert/school")
    public String insert(Model model, @RequestParam String name, @RequestParam Long capacity, @RequestParam String country) {
        model.addAttribute("school", repository.save(name, capacity, country));
        return "/jdbc/jdbcInsert/schoolInsertResult";
    }
}
