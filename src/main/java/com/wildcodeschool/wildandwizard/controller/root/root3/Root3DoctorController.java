package com.wildcodeschool.wildandwizard.controller.root.root3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Spring Quest : Root 3 */
@Controller
public class Root3DoctorController {
    @GetMapping("/root/root3/doctor")
    public String doctor() {
        return "root/root3/index";
    }

    @GetMapping("/root/root3/doctor/")
    public String doctor2(@RequestParam(required=false, defaultValue="0") int number,
                          @RequestParam(required=false, defaultValue="John Smith") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("number", number);
        return "root/root3/root3";
    }
}
