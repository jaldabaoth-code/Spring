package com.wildcodeschool.wildandwizard.controller.permissions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Spring Quest : Permissions (Login) */
@RestController
public class HelloWorldController {
    @GetMapping("/welcome")
    public String hello() {
        return "Welcome to the SHIELD";
    }

    @GetMapping("/avengers/assemble")
    public String avengers() {
        return "Avengers... Assemble";
    }

    @GetMapping("/secret-bases")
    public String base() {
        return "Biarritz, Bordeaux, La Loupe \uD83C\uDF32, Lille, Lyon, Marseille, Nantes, Orléans, Paris, Reims, Strasbourg, Toulouse, Tours, Amsterdam, Berlin, Bruxelles, Bucarest, Lisbonne, Londres, Madrid";
    }
}
