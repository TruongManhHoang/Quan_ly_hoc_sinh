package com.example.ProjectQuanLyHocSinh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MySecurity {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(
                configurer->configurer
                        // Lỗi ở form register
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .requestMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER")
                        .requestMatchers("/teacher/**").hasAnyRole("ADMIN","MANAGER","TEACHER")
                        .requestMatchers("/register/showRegisterForm").permitAll()
                        .anyRequest().permitAll()
                        /*.anyRequest().authenticated()//trang nào cũng phải đăng nhập*/
        ).formLogin(
                form->form.loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        ).logout(
                form->form.permitAll()
        ).exceptionHandling(
                configurer->configurer.accessDeniedPage("/showPage403")
                        .accessDeniedPage("/showPage404")
        );

            /*configurer->configurer.requestMatchers(HttpMethod.GET,"").hasAnyRole("TEACHER","MANAGER","ADMIN")
                    .requestMatchers(HttpMethod.GET,"").hasAnyRole("TEACHER","MANAGER","ADMIN")
                    .requestMatchers(HttpMethod.GET,"/**").hasAnyRole("TEACHER","MANAGER","ADMIN")
                    .requestMatchers(HttpMethod.POST,"").hasAnyRole("TEACHER","MANAGER","ADMIN")
                    .requestMatchers(HttpMethod.PUT,"").hasAnyRole("TEACHER","MANAGER","ADMIN")
                    .requestMatchers(HttpMethod.DELETE,"").hasAnyRole("TEACHER","MANAGER","ADMIN")*/

        /*httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf->csrf.disable());*/
        return httpSecurity.build();
    }
}
