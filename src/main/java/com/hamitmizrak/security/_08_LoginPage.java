package com.hamitmizrak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class _08_LoginPage extends WebSecurityConfigurerAdapter {
    //httpBasic Açmak istiyorsam bu metodu yazalım
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index", "/success", "/security/public") //dikkat: Controler url olacak
                .permitAll()//her isteği izin ver
                .antMatchers("/login")
                .permitAll()
                .antMatchers("/logout")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //.csrf().disable()//guvenlik zafiyeti
                .formLogin()
                .loginPage("/login")//dikkat: Controler url olacak
                .defaultSuccessUrl("/security/private") //dikkat: Controler url olacak
                .and()
                .logout()
                .logoutSuccessUrl("/logout")
                .invalidateHttpSession(true) //var olan session dataları silmek
                .permitAll();
    }
    // http://localhost:8080
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .inMemoryAuthentication()
                .withUser("hamitmizrak")
                .password("{noop}root")
                .roles("USER");
    }
}
