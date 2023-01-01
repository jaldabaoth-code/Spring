package com.wildcodeschool.wildandwizard.controller.permissions.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/* Spring Quest : Permissions (Config) */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/jpa/**").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/welcome")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/avengers/assemble").hasRole("CHAMPION")
                .and()
                .authorizeRequests()
                .antMatchers("/secret-bases").hasRole("DIRECTOR")
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("User")
                .password(encoder.encode("password"))
                .roles("")
                .and()
                .withUser("Steve")
                .password(encoder.encode("motdepasse"))
                .roles("CHAMPION")
                .and()
                .withUser("Nick")
                .password(encoder.encode("flerken"))
                .roles("DIRECTOR");
    }
}
