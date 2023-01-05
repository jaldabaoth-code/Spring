package com.wildcodeschool.wildandwizard.controller.jpa.jpa1;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.jpa.JpaSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/* Spring Quest JPA : JPA1 */
@Controller
public class Jpa1SchoolController {
    @Autowired
    private JpaSchoolRepository schoolRepository;

    /* Get all Schools */
    @GetMapping("/jpa/jpa1/schools")
    public String getAll(Model model) {
        // TODO : find all schools
        model.addAttribute("schools", schoolRepository.findAll());
        return "/jpa/jpa1/schools";
    }

    /* Get School by id */
    @GetMapping("/jpa/jpa1/school")
    public String getSchool(Model model, @RequestParam(required = false) Long id) {
        // TODO : find one school by id
        School school = new School();
        if (id != null) {
            Optional<School> optionalSchool = schoolRepository.findById(id);
            if (optionalSchool.isPresent()) {
                school = optionalSchool.get();
            }
        }
        model.addAttribute("school", school);
        return "/jpa/jpa1/school";
    }

    /* Update new School */
    @PostMapping("/jpa/jpa1/school")
    public String postSchool(@ModelAttribute School school) {
        // TODO : create or update a school
        schoolRepository.save(school);
        return "redirect:/jpa/jpa1/schools";
    }

    /* Delete the School */
    @GetMapping("/jpa/jpa1/school/delete")
    public String deleteSchool(@RequestParam Long id) {
        // TODO : delete a school
        schoolRepository.deleteById(id);
        return "redirect:/jpa/jpa1/schools";
    }
}
