package com.hamitmizrak.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings("ALL")
@Controller
public class BeanMainTest {

    @Autowired
    BeanSpringExam beanSpringExam;


    @Autowired
    BeanSpringExam beanOther;



    // http://localhost:8080/bean
    @GetMapping("/bean")
    @ResponseBody
    public String beanMain() {
        return beanSpringExam+"";
    }

    // http://localhost:8080/scope
    @GetMapping("/scope")
    @ResponseBody
    public String beanScope() {
        return "scope: "+beanSpringExam.hashCode()+" diğeri: "+beanOther.hashCode();
    }



}
