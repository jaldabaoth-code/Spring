package com.wildcodeschool.wildandwizard.controller.jdbc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quests : JDBC */
@Controller
public class JdbcController {
    @GetMapping("/jdbc")
    public String api() {
        return "/jdbc/index";
    }

}
