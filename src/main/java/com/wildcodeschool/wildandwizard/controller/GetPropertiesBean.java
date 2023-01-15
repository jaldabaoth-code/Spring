package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbc1.Jdbc1GithuberRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInsert.JdbcInsertSchoolRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInsert.JdbcInsertWizardRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcIntroduction.JdbcIntroductionPersonRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcUpdate.JdbcUpdateSchoolRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcUpdate.JdbcUpdateWizardRepository;
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
        // Quest JDBC 1
        new Jdbc1GithuberRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        // Quest JDBC Introduction
        new JdbcIntroductionPersonRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        // Quest JDBC Update
        new JdbcUpdateSchoolRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        new JdbcUpdateWizardRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        // Quest JDBC insert
        new JdbcInsertSchoolRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        new JdbcInsertWizardRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
    }
}
