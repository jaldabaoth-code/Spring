package com.wildcodeschool.wildandwizard.controller.permissions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quests : Permissions */
@Controller
public class PermissionsController {
    @GetMapping("/permissions")
    public String index() {
        return "/permissions/index";
    }
}
