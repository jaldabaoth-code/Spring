package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.repository.jdbc.jdbc1.Jdbc1GithuberRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcIntroduction.JdbcIntroductionPersonRepository;
import com.wildcodeschool.wildandwizard.repository.jdbc.jdbcUpdate.JdbcUpdateSchoolRepository;
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
        new Jdbc1GithuberRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        new JdbcIntroductionPersonRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        new JdbcUpdateSchoolRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
        new JdbcUpdateSchoolRepository().getDataParameters(databaseUrl, databaseUsername, databasePassword);
    }
}
