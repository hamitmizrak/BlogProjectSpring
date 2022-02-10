package com.hamitmizrak.ui.mvc;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // PRIVATE
    // http://localhost:8080/security/private
    @GetMapping("/security/private")
    public String getPrivate() {
        return "/private/index";
    }
}
