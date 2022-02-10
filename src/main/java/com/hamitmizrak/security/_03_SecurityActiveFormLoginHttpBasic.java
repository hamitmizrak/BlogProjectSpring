package com.hamitmizrak.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class _03_SecurityActiveFormLoginHttpBasic extends WebSecurityConfigurerAdapter {

    //httpBasic Açmak istiyorsam bu metodu yazalım
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest()//her isteği izin ver
                    .authenticated()
                    .and()
                .formLogin()
                    .and()
                .httpBasic(); //popup seklinde userName ve password acılmasına denir
    }
}
