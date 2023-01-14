package com.wildcodeschool.wildandwizard.controller.permissions.permissions1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Quest : Permissions 1 */
@RestController
public class PermissionsHelloWorldController {
    @GetMapping("/permissions/1/welcome")
    public String hello() {
        return "Welcome to the SHIELD";
    }

    @GetMapping("/permissions/1/avengers/assemble")
    public String avengers() {
        return "Avengers... Assemble";
    }

    @GetMapping("/permissions/1/secret-bases")
    public String base() {
        return "Biarritz, Bordeaux, La Loupe \uD83C\uDF32, Lille, Lyon, Marseille, Nantes, Orléans, Paris, Reims, Strasbourg, Toulouse, Tours, Amsterdam, Berlin, Bruxelles, Bucarest, Lisbonne, Londres, Madrid";
    }
}
