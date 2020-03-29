package com.config;


import com.controller.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan("com.security")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/RegistrationPage", "/LoginPage", "/", "/MainPage").anonymous()
                .antMatchers("/AdminConsole", "/StationManagement", "/ScheduleManagement", "/TrainManagement",
                        "/ScheduleUpdate", "/TrainUpdate",
                        "/StationUpdate").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/PageForCliients").access("hasRole('ROLE_USER')")
                .anyRequest().authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage("/LoginPage")
                .loginProcessingUrl("/LoginPage/process")
                .usernameParameter("username")
                .failureUrl("/LoginPage?error=true")
                .successHandler(CustomAuthenticationSuccessHandler())
                .and()
                .exceptionHandling()
                .accessDeniedPage("/Error")
                .and().logout();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public AuthenticationSuccessHandler CustomAuthenticationSuccessHandler(){
        return new CustomAuthenticationSuccessHandler();
    }

}