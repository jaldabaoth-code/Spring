package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.repository.jdbc.GithuberRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.PersonRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.JDBCSchoolRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.JDBCWizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GetPropertiesBean {
    public GetPropertiesBean() {
    }

    @Autowired
    public GetPropertiesBean(@Value("${spring.datasource.url}") String databaseUrl,
                             @Value("${spring.datasource.username}") String databaseUsername,
                             @Value("${spring.datasource.password}") String databasePassword
    ) {
        new GithuberRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        new PersonRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        new JDBCSchoolRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        new JDBCWizardRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
    }
}
