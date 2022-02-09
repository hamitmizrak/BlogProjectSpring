package com.hamitmizrak.business.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class WriterDto {

    private Long writerId;
    private String writerName;
    private String writerSurname;
    private Date date;

    //objenin kendisini kullanmadım bazen Objenin hepsini veriliyor sadece Id veya name lazım oluyor.
    //private WriterDto writerDto;
    private Long bookId;
    private String bookName;



}
