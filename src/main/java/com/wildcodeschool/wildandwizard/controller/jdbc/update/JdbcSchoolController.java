package com.wildcodeschool.wildandwizard.controller.jdbc.update;

import com.wildcodeschool.wildandwizard.repository.jdbc.JDBCSchoolRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JdbcSchoolController {

    private JDBCSchoolRepository repository = new JDBCSchoolRepository();

    @GetMapping("/jdbc/school/update")
    public String getSchoolUpdate(Model model,
                                  @RequestParam Long id
    ) {
        model.addAttribute("school", repository.findById(id));

        return "jdbc/update/school_update";
    }


    @GetMapping("/jdbc/update/index")
    public String postIndex() {


        return "jdbc/update/index";
    }

    @PostMapping("/jdbc/school/update")
    public String postSchoolUpdate(Model model,
                                   @RequestParam Long id,
                                   @RequestParam String name,
                                   @RequestParam Long capacity,
                                   @RequestParam String country
    ) {
        model.addAttribute("school", repository.update(id, name, capacity, country));

        return "jdbc/update/school_get";
    }
}
