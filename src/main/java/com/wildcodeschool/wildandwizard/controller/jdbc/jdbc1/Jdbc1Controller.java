package com.wildcodeschool.wildandwizard.controller.jdbc.jdbc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : JDBC 1 */
@Controller
public class Jdbc1Controller {
    @GetMapping("/jdbc/1")
    public String index() {
        return "/jdbc/jdbc1/index";
    }
}
