package com.wildcodeschool.wildandwizard.controller.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Spring Quests : Root */
@Controller
public class DoctorController {
    @GetMapping("/root")
    public String doctor() {
        return "root/index";
    }
}
