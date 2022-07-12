package com.wildcodeschool.wildandwizard.controller.jpa;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/* Spring Quests : JPA (School) */
@Controller
public class SchoolController {
    @Autowired
    private SchoolRepository schoolRepository;

    /* Spring Quest : JPA (Get all Schools) */
    @GetMapping("/jpa/schools")
    public String getAll(Model model) {
        // TODO : find all schools
        model.addAttribute("schools", schoolRepository.findAll());
        return "/jpa/schools";
    }

    /* Spring Quest : JPA (Get School by id) */
    @GetMapping("/jpa/school")
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
        return "/jpa/school";
    }

    /* Spring Quest : JPA (Update new School) */
    @PostMapping("/jpa/school")
    public String postSchool(@ModelAttribute School school) {
        // TODO : create or update a school
        schoolRepository.save(school);
        return "redirect:/jpa/schools";
    }

    /* Spring Quest : JPA (Delete the School) */
    @GetMapping("/jpa/school/delete")
    public String deleteSchool(@RequestParam Long id) {
        // TODO : delete a school
        schoolRepository.deleteById(id);
        return "redirect:/jpa/schools";
    }
}
