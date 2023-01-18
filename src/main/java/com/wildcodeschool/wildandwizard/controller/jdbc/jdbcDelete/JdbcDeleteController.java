package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcDelete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : JDBC Delete */
@Controller
public class JdbcDeleteController {
    @GetMapping("/jdbc/delete")
    public String index() {
        return "/jdbc/jdbcDelete/index";
    }
}
