package com.hamitmizrak.security.userserviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    //bu metotta kullanıcı adı verdiğimizde o kullanıcı hakkında roller,şifrev.b verecektir.
    //şifresi doğru olsun ve hangi kullanıcı olursa olsun giriş sağlansın
    // database kullanıcı dataları kullanma örneği
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //database gelen bilgiler ben manuel girdim
        //userName: database aldığımız ,userName,password,role kullanabiliriz.
        String password = "root";
        String role = "USER";
        //String [] role={"USER","ADMIN"}; //eğer birden fazla rol varsa
        return User
                .withUsername(username)
                .password( passwordEncoder.encode(password)) //database gelen data maskelenmiş bir şekildeyse
                .roles(role)
                .build();
    }
}
