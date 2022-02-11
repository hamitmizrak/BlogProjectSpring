package com.hamitmizrak.ui.mvc;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
public class SecurityController {
    // LOGIN
    // http://localhost:8080/login
    //     @GetMapping("/login")
    //     public String getLogin() {
    //         return "/login";
    //     }

    // LOGIN ERROR
    // http://localhost:8080/login
    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("key_message", "username veya password hatalı");
        } else {
            model.addAttribute("key_message", "lütfen bilgileri giriniz");
        }
        return "/login";
    }


    // LOGIN LOGOUT
    // http://localhost:8080/logout
    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request, HttpServletResponse response, Model model) {
        //Sayfaya giriş yapmış user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            model.addAttribute("key_logout", "Çıkış başarılı");
        } else {
            model.addAttribute("key_logout", "Çıkış başarısız !!!!");
        }
        return "/logout";
    }


    // USER
    // http://localhost:8080/user
    @GetMapping("/user")
    @ResponseBody
    public String getUser() {
        //Sayfaya giriş yapmış user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            System.out.println(authentication.hashCode());
            return authentication.getName() + " " + authentication.hashCode();
        }
        return "Sistemde giriş yapmış kullaıcı bulunmuyor.";
    }


    // PRIVATE
    // http://localhost:8080/security/private
    @GetMapping("/security/private")
    public String getPrivate(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = "";
        if (authentication != null) {
            user = authentication.getName();
        }
        model.addAttribute("system_user", user);
        return "/private/index";
    }


    // AnaDizin
    // http://localhost:8080/index
    @GetMapping("/index")
    public String getIndex() {
        return "/index";
    }

    // PUBLIC
    // http://localhost:8080/security/public
    @GetMapping("/security/public")
    public String getpublic() {
        return "/public/index";
    }

    // PUBLIC
    // http://localhost:8080/success
    @GetMapping("/success")
    public String getpublic2() {
        return "/success";
    }


}
