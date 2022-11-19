package com.lao.websekyu.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and()
                .authorizeRequests(requests -> requests
                        .mvcMatchers("/login").permitAll()
                        .mvcMatchers(HttpMethod.GET, "/login-success").authenticated()
                        .mvcMatchers(HttpMethod.GET,"/whoami").authenticated()
                    .anyRequest().denyAll())
                .oauth2Login()
                .loginPage("/login");
        return http.build();
    }

}