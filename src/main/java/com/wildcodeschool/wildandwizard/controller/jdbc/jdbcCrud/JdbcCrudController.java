package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcCrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : JDBC CRUD */
@Controller
public class JdbcCrudController {
    @GetMapping("/jdbc/crud")
    public String index() {
        return "/jdbc/jdbcCrud/index";
    }
}