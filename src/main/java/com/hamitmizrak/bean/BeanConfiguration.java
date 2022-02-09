package com.hamitmizrak.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//Bean yazmak ve isteyen yerde kullanmaya denilir.
//Bean görevi elimizde hazır data olsun istediğim yerde kullanabilmek için
@Configuration
public class BeanConfiguration {


    @Bean(initMethod = "initializedBean44",destroyMethod = "destroydBean44")
    @Scope("prototype")
    public BeanSpringExam beanSpringExam() {
        BeanSpringExam beanSpringExam = new BeanSpringExam();
        beanSpringExam.setId(1L);
        beanSpringExam.setName("config name");
        beanSpringExam.setSurname("config surname");
        return beanSpringExam;
    }

}
