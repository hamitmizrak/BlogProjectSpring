package com.hamitmizrak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class _10_Authorization extends WebSecurityConfigurerAdapter {
    //httpBasic Açmak istiyorsam bu metodu yazalım
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()//her isteği izin ver
                .antMatchers( "/writer").hasRole("USER")
                .antMatchers( "/admin").hasRole("ADMIN")
                //.antMatchers( "/writer/writer").hasAnyRole("USER","ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    //.and() diğer özelliklere geçiş için gerekli
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .inMemoryAuthentication()
                // http://localhost:8080/admin
                //admin kullanıcısı hem ADMIN hemde USER sayfasına giriş yapabilir
                  .withUser("admin")
                     .password("{noop}root")
                     .roles("ADMIN","USER")
                  .and()
                // http://localhost:8080/writer
                //writer kullanıcısı sade USER sayfasına giriş yapabilir.
                  .withUser("writer")
                    .password("{noop}root")
                    .roles("USER")
                  .and();
    }
}
