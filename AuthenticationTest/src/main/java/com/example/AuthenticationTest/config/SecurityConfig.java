package com.example.AuthenticationTest.config;

import com.example.AuthenticationTest.helper.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;


    public SecurityConfig(JwtAuthenticationFilter jwtFilter, AuthenticationProvider authenticationProvider) {
        this.jwtFilter = jwtFilter;
        this.authenticationProvider = authenticationProvider;
    }




  /*  The security filter chain is a sequence of filters that Spring Security applies to
    each incoming HTTP request. These filters work together to perform various security-related tasks.*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/api-docs/**").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/gateway").permitAll()
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider)//AuthenticationProviders has all the core logic of validating user details for authentication
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        // AuthenticationProviders has all the core logic of validating user details for authentication
        // will extract username/password from HTTP request & prepare Authentication type object
      return http.build();
    }


}







