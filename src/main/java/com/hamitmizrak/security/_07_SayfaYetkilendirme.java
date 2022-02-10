package com.hamitmizrak.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class _07_SayfaYetkilendirme extends WebSecurityConfigurerAdapter {

    //httpBasic Açmak istiyorsam bu metodu yazalım
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/","/index","/success","/security/public") //dikkat: Controler url olacak
                    //.antMatchers("/","/index","/success","/templates/public/index").hasRole("USER")
                    .permitAll()//her isteği izin ver
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .and()
                .httpBasic(); //popup seklinde userName ve password acılmasına denir
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
