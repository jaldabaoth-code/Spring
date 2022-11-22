package com.wildcodeschool.wildandwizard.controller.root;

import com.wildcodeschool.wildandwizard.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

/* Spring Quests : Root (Doctor) */
@Controller
public class DoctorController {
    @GetMapping("/doctor")
    public String doctor() {
        return "root/root";
    }

    /* Spring Quest : Root 1 (Doctor) */
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

    /* Spring Quest : Root 2 (Doctor) */
    @GetMapping("root/root2/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {
        if(number == 13){
            return new Doctor(13, "Jodie Whitakker");
        } else if ( number >=1 && number <=12){
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Code 303");
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);
    }

    /* Spring Quest : Root 3 (Doctor) */
    @GetMapping("/root/root3/doctor/")
    public String doctor2(@RequestParam(required=false, defaultValue="0") int number,
                         @RequestParam(required=false, defaultValue="John Smith") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("number", number);
        return "root/root3";
    }
}
