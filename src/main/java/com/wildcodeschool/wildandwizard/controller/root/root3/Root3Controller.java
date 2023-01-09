package com.wildcodeschool.wildandwizard.controller.root.root3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : Root 3 */
@Controller
public class Root3Controller {
    @GetMapping("/root/3")
    public String index() {
        return "/root/root3/index";
    }
}
