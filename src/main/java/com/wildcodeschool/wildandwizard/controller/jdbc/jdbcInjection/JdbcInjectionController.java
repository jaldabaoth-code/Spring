package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcInjection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : JDBC Injection */
@Controller
public class JdbcInjectionController {
    @GetMapping("/jdbc/injection")
    public String index() {
        return "/jdbc/jdbcInjection/index";
    }
}
