package com.wildcodeschool.wildandwizard.controller.permissions.permissions1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : Permissions 1 */
@Controller
public class Permissions1Controller {
    @GetMapping("/permissions/1")
    public String index() {
        return "/permissions/permissions1/index";
    }
}
