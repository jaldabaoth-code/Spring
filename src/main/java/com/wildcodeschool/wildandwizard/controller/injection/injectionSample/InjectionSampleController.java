package com.wildcodeschool.wildandwizard.controller.injection.injectionSample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Quest : Injection Sample */
@Controller
public class InjectionSampleController {
    @GetMapping("/injection/sample")
    public String index() {
        return "/injection/injectionSample/index";
    }
}
