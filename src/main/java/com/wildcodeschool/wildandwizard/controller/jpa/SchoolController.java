package com.wildcodeschool.wildandwizard.controller.jpa;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.SchoolRepository;
import com.wildcodeschool.wildandwizard.repository.WizardRepository;
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

/* Spring Quests : JPA (School) */
@Controller
public class SchoolController {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private WizardRepository wizardRepository;

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

    /* Spring Quest : JPA One To Many (Show wizards of school) */
    @GetMapping("/jpa/school/wizards")
    public String getSchoolWizards(Model model, @RequestParam Long idSchool) {
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
        return "jpa/schoolWizard.html";
    }

    /* Spring Quest : JPA One To Many (Add a wizard to school) */
    @PostMapping("/jpa/school/wizard/register")
    public String postSchoolWizardRegister(@RequestParam Long idSchool, @RequestParam Long idWizard) {
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
        return "redirect:/jpa/school/wizards?idSchool=" + idSchool;
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
