package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcSelect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : JDBC Select */
@Controller
public class JdbcSelectController {
    @GetMapping("/jdbc/select")
    public String index() {
        return "/jdbc/jdbcSelect/index";
    }
}
