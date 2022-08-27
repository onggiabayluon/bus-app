/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.temtree.handlers.CustomLogoutSuccessHandler;
import com.temtree.handlers.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author admin
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.temtree.repository",
    "com.temtree.services"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dwajvm53v",
                "api_key", "485633522843934",
                "api_secret", "gZYmgO8732Xzcms1AJeU1_ReCGU",
                "secure", true));
        return cloudinary;
    }

    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired
    private LogoutSuccessHandler customLogoutSuccessHandler;

    @Bean
    public AuthenticationSuccessHandler LoginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LogoutSuccessHandler CustomLogoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");

        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");

        http.formLogin().successHandler(this.loginSuccessHandler);

        http.logout().logoutSuccessUrl("/login");

        http.logout().logoutSuccessHandler(this.customLogoutSuccessHandler);

        http.exceptionHandling()
                .accessDeniedPage("/login?accessDenied");

        
        String isLoggedIn = "hasAuthority('USER') or hasAuthority('ADMIN') or hasAuthority('DRIVER') or hasAuthority('EMPLOYEE')";
        
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/carts").access(isLoggedIn)
                .antMatchers("/confirm").access(isLoggedIn)
                .antMatchers("/book-ticket").access(isLoggedIn)
                .antMatchers("/pay").access(isLoggedIn)
                .antMatchers("/admin/add").access("hasAuthority('ADMIN') or hasAuthority('EMPLOYEE')")
                .antMatchers("/admin/**").hasAuthority("ADMIN");
                

        http.csrf().disable();
    }

}
