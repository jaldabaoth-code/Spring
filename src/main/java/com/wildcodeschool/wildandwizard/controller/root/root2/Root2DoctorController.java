package com.wildcodeschool.wildandwizard.controller.root.root2;

import com.wildcodeschool.wildandwizard.model.root.root2.Root2Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

/* Quest : Root 2 */
@Controller
public class Root2DoctorController {
    @GetMapping("/root/2/doctor/{number}")
    @ResponseBody
    public Root2Doctor doctor(@PathVariable int number) {
        if (number == 13) {
            return new Root2Doctor(13, "Jodie Whitakker");
        } else if (number >= 1 && number <= 12) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Code 303");
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to recover incarnation " + number);
    }
}
