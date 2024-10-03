package com.example.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/login", "/register", "/register/**", "/clubs", "/clubs/**", "/events", "/events/**", "/css/**", "/js/**")
                .permitAll())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .failureUrl("/login?error=true")  // On login failure
                        .defaultSuccessUrl("/clubs", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/login?logout=true")  // On logout success
                        .permitAll()
                );
        return http.build();
    }
}