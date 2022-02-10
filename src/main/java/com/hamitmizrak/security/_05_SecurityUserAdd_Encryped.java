package com.hamitmizrak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
public class _05_SecurityUserAdd_Encryped extends WebSecurityConfigurerAdapter {

    // kullanıcı eklemek
    // http://localhost:8080
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {

        PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();

        authentication
                .inMemoryAuthentication()//authentication bellek üzerinden database değil
                .withUser("hamitmizrak")
                // .password("root") //bu haliyle encrypted yani database şifreleyerek saklar
                //.password("{noop}root") //bu haliyle database şifrelenmeden saklamaya yapar
                .password(passwordEncoder.encode("root"))
                //md4 md5 noop sha-1 sha-256 sha256
                .roles("USER");//roller genelde buyuk harflerlerle yazıyoruz.
    }
}
