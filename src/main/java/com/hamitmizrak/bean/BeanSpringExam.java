package com.hamitmizrak.bean;

import lombok.*;

@Getter
@Setter

public class BeanSpringExam {
    private Long id;
    private String name;
    private String surname;


    public void initializedBean44(){
        System.out.println("Başlangıçta çalıştım ");
    }

    public void destroydBean44(){
        System.out.println("Bitişte bittim ");
    }

}
