package com.hamitmizrak.security;

import com.hamitmizrak.security.userserviceImpl.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class _09_UserDatabase extends WebSecurityConfigurerAdapter {
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

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    // http://localhost:8080
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }
}
