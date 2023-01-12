package com.wildcodeschool.wildandwizard.controller.jdbc.jdbcIntroduction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : JDBC Introduction */
@Controller
public class JdbcIntroductionController {
    @GetMapping("/jdbc/introduction")
    public String index() {
        return "jdbc/jdbcIntroduction/index";
    }
}
