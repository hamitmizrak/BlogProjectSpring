package com.hamitmizrak.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//diger classdaki calissin diye kapattım
//@EnableWebSecurity
public class _02_SecurityActiveHttpBasic extends WebSecurityConfigurerAdapter {


    //httpBasic Açmak istiyorsam bu metodu yazalım
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest()//her isteği izin ver
                    .authenticated()
                    .and()
                .httpBasic(); //popup seklinde userName ve password acılmasına denir
    }
}
