package com.wildcodeschool.wildandwizard.controller.jpa.jpaOneToMany;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.jpa.jpaOneToMany.JpaOneToManySchoolRepository;
import com.wildcodeschool.wildandwizard.repository.jpa.jpaOneToMany.JpaOneToManyWizardRepository;
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

/* Quest : One To Many */
@Controller
public class JpaOneToManySchoolController {
    @Autowired
    private JpaOneToManyWizardRepository wizardRepository;
    @Autowired
    private JpaOneToManySchoolRepository schoolRepository;

    @GetMapping("/jpa/one-to-many/schools")
    public String getAll(Model model) {
        model.addAttribute("schools", schoolRepository.findAll());
        return "/jpa/jpaOneToMany/schools";
    }

    @GetMapping("/jpa/one-to-many/school")
    public String getById(Model model, @RequestParam(required = false) Long id) {
        School school = new School();
        if (id != null) {
            Optional<School> optionalSchool = schoolRepository.findById(id);
            if (optionalSchool.isPresent()) {
                school = optionalSchool.get();
            }
        }
        model.addAttribute("school", school);
        return "/jpa/jpaOneToMany/school";
    }

    @PostMapping("/jpa/one-to-many/school")
    public String save(@ModelAttribute School school) {
        schoolRepository.save(school);
        return "redirect:/jpa/one-to-many/schools";
    }

    @GetMapping("/jpa/one-to-many/school/delete")
    public String delete(@RequestParam Long id) {
        schoolRepository.deleteById(id);
        return "redirect:/jpa/one-to-many/schools";
    }

    @GetMapping("/jpa/one-to-many/school/wizards")
    public String getWizardsBySchoolId(Model model, @RequestParam Long idSchool) {
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
        return "/jpa/jpaOneToMany/registerWizardToSchool";
    }

    @PostMapping("/jpa/one-to-many/school/wizard")
    public String registerWizardInSchool(@RequestParam Long idSchool, @RequestParam Long idWizard) {
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
