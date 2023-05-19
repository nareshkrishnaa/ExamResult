package com.naresh.examresult.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests((authorize) -> {
            authorize.requestMatchers(HttpMethod.GET,"/student/all").hasAnyRole("ADMIN","TEACHER");

            authorize.requestMatchers(HttpMethod.POST,"/student/create").hasAnyRole("ADMIN","TEACHER");

            authorize.requestMatchers(HttpMethod.POST,"/teacher/create").hasAnyRole("ADMIN");

            authorize.requestMatchers(HttpMethod.GET,"/teacher/login/**").hasAnyRole("TEACHER");

            authorize.requestMatchers(HttpMethod.GET,"/student/get-result/**").hasRole("STUDENT");

            authorize.requestMatchers(HttpMethod.GET,"/student/login/**").hasRole("STUDENT");

            authorize.requestMatchers(HttpMethod.GET,"/student/get-student/**").hasAnyRole("ADMIN","TEACHER");

            authorize.requestMatchers(HttpMethod.PUT,"/student/update/**").hasAnyRole("ADMIN","TEACHER");

            authorize.requestMatchers(HttpMethod.DELETE,"/student/**").hasAnyRole("ADMIN","TEACHER");

            authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails student = User.builder().
                username("student").
                password(passwordEncoder().encode("pwd")).
                roles("STUDENT").
                build();

        UserDetails teacher = User.builder().
                username("teacher").
                password(passwordEncoder().encode("pwd")).
                roles("TEACHER").
                build();

        UserDetails admin = User.builder().
                username("admin").
                password(passwordEncoder().encode("pwd")).
                roles("ADMIN").
                build();

        return new InMemoryUserDetailsManager(student, admin,teacher);
    }
}