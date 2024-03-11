package com.dev.todoApplication.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer; 
import org.springframework.security.core.userdetails.User; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder;  
import org.springframework.security.provisioning.InMemoryUserDetailsManager; 
import org.springframework.security.web.SecurityFilterChain; 

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//Used to enable web security features in spring boot application
@EnableWebSecurity
public class spingSecurityConfiguration {
     
    @Bean
    public InMemoryUserDetailsManager createUserDetails(){
        Function<String, String> passwordEncoder= input -> passwordEncoder().encode(input);
        
        UserDetails userDetails=User.builder()
        .passwordEncoder(passwordEncoder) 
        .username("Admin")
        .password("Admin")
        .roles("USER","ADMIN")
        .build();
        
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//FilterChain bean serves as an entry point for all http requests
//It consists of various filters responsible for handling authentication, authorization, CSRF protection, etc
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
      .authenticated())
      .httpBasic(withDefaults())
      .formLogin(withDefaults())  
      .csrf(AbstractHttpConfigurer::disable);
    return http.build();
}

}
