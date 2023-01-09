package com.wildcodeschool.wildandwizard.controller.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quests : Root */
@Controller
public class RootController {
    @GetMapping("/root")
    public String root() {
        return "/root/index";
    }
}
