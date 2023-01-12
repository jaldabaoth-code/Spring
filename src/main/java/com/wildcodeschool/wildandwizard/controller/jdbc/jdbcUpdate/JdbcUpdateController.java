package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcUpdate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : JDBC Update */
@Controller
public class JdbcUpdateController {
    @GetMapping("/jdbc/update")
    public String index() {
        return "/jdbc/jdbcUpdate/index";
    }
}
