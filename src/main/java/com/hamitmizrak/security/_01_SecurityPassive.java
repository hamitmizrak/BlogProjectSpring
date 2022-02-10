package com.hamitmizrak.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//diger classdaki calissin diye kapattım
//@EnableWebSecurity
public class _01_SecurityPassive extends WebSecurityConfigurerAdapter {

    //kapatmak istiyorsam bu metodu yazalım
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    }
}
