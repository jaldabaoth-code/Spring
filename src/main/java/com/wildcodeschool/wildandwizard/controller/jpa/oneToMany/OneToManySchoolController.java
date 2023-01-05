package com.wildcodeschool.wildandwizard.controller.jpa.oneToMany;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.jpa.JpaSchoolRepository;
import com.wildcodeschool.wildandwizard.repository.jpa.JpaWizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* JPA Quest : One To Many */
@Controller
public class OneToManySchoolController {
    @Autowired
    private JpaWizardRepository wizardRepository;
    @Autowired
    private JpaSchoolRepository schoolRepository;

    /* Get all Schools */
    @GetMapping("/jpa/one-to-many/schools")
    public String getAll(Model model) {
        model.addAttribute("schools", schoolRepository.findAll());
        return "/jpa/oneToMany/schools";
    }

    /* Get School by id */
    @GetMapping("/jpa/one-to-many/school")
    public String getSchool(Model model, @RequestParam(required = false) Long id) {
        School school = new School();
        if (id != null) {
            Optional<School> optionalSchool = schoolRepository.findById(id);
            if (optionalSchool.isPresent()) {
                school = optionalSchool.get();
            }
        }
        model.addAttribute("school", school);
        return "/jpa/oneToMany/school";
    }

    /* Create or Update a School */
    @PostMapping("/jpa/one-to-many/school")
    public String postSchool(@ModelAttribute School school) {
        schoolRepository.save(school);
        return "redirect:/jpa/one-to-many/schools";
    }

    /* Delete the School */
    @GetMapping("/jpa/one-to-many/school/delete")
    public String deleteSchool(@RequestParam Long id) {
        schoolRepository.deleteById(id);
        return "redirect:/jpa/one-to-many/schools";
    }

    /* Get all wizards in school */
    @GetMapping("/jpa/one-to-many/school/wizards")
    public String getWizards(Model model, @RequestParam Long idSchool) {
        Optional<School> optionalSchool = schoolRepository.findById(idSchool);
        School school = new School();
        if (optionalSchool.isPresent()) {
            school = optionalSchool.get();
        }
        model.addAttribute("school", school);
        model.addAttribute("allWizards", wizardRepository.findAll());
        // Call the method getWizards in School
        List<Wizard> wizards = new ArrayList<>();
        Method method = getMethod(school, "getWizards", new Class[]{});
        if (method != null) {
            try {
                wizards = (List<Wizard>) method.invoke(school);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("schoolWizards", wizards);
        return "jpa/oneToMany/schoolWizards";
    }

    /* Register new wizard in school */
    @PostMapping("/jpa/one-to-many/school/wizard")
    public String postWizard(@RequestParam Long idSchool, @RequestParam Long idWizard) {
        Optional<Wizard> optionalWizard = wizardRepository.findById(idWizard);
        if (optionalWizard.isPresent()) {
            Wizard wizard = optionalWizard.get();
            Optional<School> optionalSchool = schoolRepository.findById(idSchool);
            if (optionalSchool.isPresent()) {
                School school = optionalSchool.get();
                // Call the method setSchool in Wizard
                Method method = getMethod(wizard, "setSchool", new Class[]{School.class});
                if (method != null) {
                    try {
                        method.invoke(wizard, school);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                wizardRepository.save(wizard);
            }
        }
        return "redirect:/jpa/one-to-many/school/wizards?idSchool=" + idSchool;
    }

    public Method getMethod(Object obj, String methodName, Class[] args) {
        Method method;
        try {
            method = obj.getClass().getDeclaredMethod(methodName, args);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
