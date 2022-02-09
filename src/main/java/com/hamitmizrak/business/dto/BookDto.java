package com.hamitmizrak.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class BookDto {

    private Long bookId;
    private String bookName;
    private double Price;
    private Date date;

    //objenin kendisini kullanmadım bazen Objenin hepsini veriliyor sadece Id veya name lazım oluyor.
    //private WriterDto writerDto;
    private Long writerId;
    private String writerName;

}
