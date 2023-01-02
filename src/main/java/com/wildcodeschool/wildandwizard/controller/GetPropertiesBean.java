package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.repository.GithuberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetPropertiesBean {


    private String foo;
    private String foo1;
    private String foo2;

    public GetPropertiesBean() {

    }
    private String tata;
    @Autowired
    public GetPropertiesBean(@Value("${spring.datasource.url}") String foo,
                             @Value("${spring.datasource.username}") String foo2,
                             @Value("${spring.datasource.password}") String foo3

                             ) {

        new GithuberRepository().setTest(foo, foo2, foo3);

        this.foo = foo;
        System.out.println(foo);

    }


}