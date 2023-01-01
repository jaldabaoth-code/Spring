package com.wildcodeschool.wildandwizard.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "races")
    private List<Wizard> wizards = new ArrayList<>();

    public Race() {
    }

    public Race(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Wizard> getWizards() {
        return wizards;
    }

    public void setWizards(List<Wizard> wizards) {
        this.wizards = wizards;
    }
}
