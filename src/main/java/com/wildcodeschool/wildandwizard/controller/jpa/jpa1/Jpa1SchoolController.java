package com.wildcodeschool.wildandwizard.controller.jpa.jpa1;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.jpa.jpa1.Jpa1SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

/* Quest : JPA 1 */
@Controller
public class Jpa1SchoolController {
    @Autowired
    private Jpa1SchoolRepository schoolRepository;

    @GetMapping("/jpa/1/schools")
    public String getAll(Model model) {
        model.addAttribute("schools", schoolRepository.findAll());
        return "/jpa/jpa1/schools";
    }

    @GetMapping("/jpa/1/school")
    public String getById(Model model, @RequestParam(required = false) Long id) {
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

    @PostMapping("/jpa/1/school")
    public String save(@ModelAttribute School school) {
        schoolRepository.save(school);
        return "redirect:/jpa/1/schools";
    }

    @GetMapping("/jpa/1/school/delete")
    public String delete(@RequestParam Long id) {
        schoolRepository.deleteById(id);
        return "redirect:/jpa/1/schools";
    }
}
