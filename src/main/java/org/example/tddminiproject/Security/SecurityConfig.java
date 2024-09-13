package org.example.tddminiproject.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF using new syntax
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll())  // Allow all requests without authentication
                .httpBasic(Customizer.withDefaults())  // Disable basic authentication
                .formLogin(Customizer.withDefaults());  // Disable form login (if applicable)
        return http.build();
    }
}

