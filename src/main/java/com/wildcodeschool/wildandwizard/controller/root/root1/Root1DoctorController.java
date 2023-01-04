package com.wildcodeschool.wildandwizard.controller.root.root1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/* Root Quest : Root 1 */
@Controller
public class Root1DoctorController {
    @GetMapping("root/root1/doctor/1")
    @ResponseBody
    public String william() {
        return "William Hartnell";
    }

    @GetMapping("root/root1/doctor/10")
    @ResponseBody
    public String david() {
        return "David Tennant";
    }

    @GetMapping("root/root1/doctor/12")
    @ResponseBody
    public String jodie() {
        return "Jodie Whittaker";
    }
}
