package com.greatLearning.employeeService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatLearning.employeeService.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/api/user", "/api/role").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.POST, "/api/employees").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.PUT, "/api/employees").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/api/employees/{employeeId}").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.GET, "/api/employees/customsort", "/api/employees/search/{firstName}")
            .hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/swagger-ui.html**", "/swagger-resources/**", "/v2/api-docs", "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and().httpBasic()
            .and().cors().and().csrf().disable();
    }
}
