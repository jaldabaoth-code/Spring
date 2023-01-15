package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcInsert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : JDBC Insert */
@Controller
public class JdbcInsertController {
    @GetMapping("/jdbc/insert")
    public String index() {
        return "/jdbc/jdbcInsert/index";
    }

    @GetMapping("/jdbc/insert/school")
    public String index2() {
        return "/jdbc/jdbcInsert/school";
    }
}
