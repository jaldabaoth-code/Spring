package com.wildcodeschool.wildandwizard.controller.permissions.permissions1.permissionsConfig;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/* Quest : Permissions 1 */
@EnableWebSecurity
public class PermissionsMySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/jpa/**", "/jdbc/**").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/permissions/1/welcome")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/permissions/1/avengers/assemble").hasRole("CHAMPION")
                .and()
                .authorizeRequests()
                .antMatchers("/permissions/1/secret-bases").hasRole("DIRECTOR")
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
                .password(encoder.encode("captain"))
                .roles("CHAMPION")
                .and()
                .withUser("Nick")
                .password(encoder.encode("flerken"))
                .roles("DIRECTOR");
    }
}
