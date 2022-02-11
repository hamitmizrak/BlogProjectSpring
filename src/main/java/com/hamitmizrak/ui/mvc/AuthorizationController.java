package com.hamitmizrak.ui.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//Belirli sayfalara belirli kişiler girebilsin(Authorization)
public class AuthorizationController {

    //admin bütün sayfalara erişim vardır.
    //writer sadece kendi sayfasına erişim vardır.

    // SUPER ADMIN
    // http://localhost:8080/admin
    // admin root
    @GetMapping("/admin")
    public String getLogin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = "";
        if (authentication != null) {
            user = authentication.getName();
        }
        model.addAttribute("system_user", user);
        return "/superadmin/secret";
    }

    // WRITER
    // writer root
    // http://localhost:8080/writer
    @GetMapping("/writer")
    public String getWriter(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = "";
        if (authentication != null) {
            user = authentication.getName();
        }
        model.addAttribute("system_user", user);
        return "/writer/public";
    }

    // ROLES
    @GetMapping("/roles")
    @ResponseBody
    public String getRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String rols = "";
        if (authentication != null) {
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                rols += grantedAuthority.getAuthority() + " ";
            }
        }
        return " Sistem Yetkilendirme kişileri: " + rols;
    }

    // FarkliKullanicilar Aynı Sayfada Farkl kullanıcılar
    // http://localhost:8080/spesific_page
    @GetMapping("/spesific_page")
    public String getSpesific(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = "";
        if (authentication != null) {
            user = authentication.getName();
        }
        model.addAttribute("system_user", user);
        return "/aynisayfafarklikullanici/farklıkullanicilar";
    }
}
