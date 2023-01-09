package com.wildcodeschool.wildandwizard.controller.jdbc.jdbc1;

import com.wildcodeschool.wildandwizard.entity.Githuber;
import com.wildcodeschool.wildandwizard.repository.jdbc.GithuberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* JDBC Quest : JDBC 1 */
@Controller
public class JdbcGitHuberController {
    private GithuberRepository repository = new GithuberRepository();

    @GetMapping("/jdbc/1/githubers")
    public String getAll(Model model) {
        model.addAttribute("githubers", repository.findAll());
        return "jdbc/1/githubers";
    }

    @GetMapping("/jdbc/1/githuber")
    public String getGithuber(Model model, @RequestParam(required = false) Long id) {
        Githuber githuber = new Githuber();
        if (id != null) {
            githuber = repository.findById(id);
        }
        model.addAttribute("githuber", githuber);
        return "jdbc/1/githuber";
    }

    @PostMapping("/jdbc/1/githuber")
    public String postGithuber(@ModelAttribute Githuber githuber) {
        if (githuber.getId() != null) {
            repository.update(githuber);
        } else {
            repository.save(githuber);
        }
        return "redirect:/jdbc/1/githubers";
    }

    @GetMapping("/jdbc/1/githuber/delete")
    public String deleteGithuber(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/jdbc/1/githubers";
    }
}
