package com.hamitmizrak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class _06_SecurityUserAdd_Encryped_Bean extends WebSecurityConfigurerAdapter {

    @Bean //springte diğer kullanıcılarda bu metodu kullansın diye @Bean yaptım.
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    // kullanıcı eklemek
    // http://localhost:8080
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .inMemoryAuthentication()//authentication bellek üzerinden database değil
                .withUser("hamitmizrak")
                .password(passwordEncoder().encode("root"))
                .roles("USER");
    }
}
