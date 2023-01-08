package com.wildcodeschool.wildandwizard.controller.root.root2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Root Quest : Root 2 */
@Controller
public class Root2Controller {
    @GetMapping("/root/root-2")
    public String index() {
        return "root/root2/index";
    }
}
