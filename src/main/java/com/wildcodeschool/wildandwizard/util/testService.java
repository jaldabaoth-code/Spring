package com.wildcodeschool.wildandwizard.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class testService {


    @Value("${spring.datasource.username}")
    private static String username;

    @Value("${spring.datasource.password}")
    private String password;

    private String toto = "test";

    public static String test() {
        return username;
    }
}
