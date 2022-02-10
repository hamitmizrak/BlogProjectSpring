package com.hamitmizrak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class _04_SecurityUserAdd_NoEncryped extends WebSecurityConfigurerAdapter {


    // kullanıcı eklemek
    // http://localhost:8080
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .inMemoryAuthentication()//authentication bellek üzerinden database değil
                .withUser("hamitmizrak")
                // .password("root") //bu haliyle encrypted yani database şifreleyerek saklar
                .password("{noop}root") //bu haliyle database şifrelenmeden saklamaya yapar
                .roles("USER");//roller genelde buyuk harflerlerle yazıyoruz.
    }


}
