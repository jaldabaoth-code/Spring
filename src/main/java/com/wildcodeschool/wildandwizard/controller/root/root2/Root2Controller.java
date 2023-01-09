package com.wildcodeschool.wildandwizard.controller.root.root2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : Root 2 */
@Controller
public class Root2Controller {
    @GetMapping("/root/2")
    public String index() {
        return "root/root2/index";
    }
}
