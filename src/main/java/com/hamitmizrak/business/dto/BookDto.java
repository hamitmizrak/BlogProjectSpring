package com.hamitmizrak.business.dto;

import com.hamitmizrak.data.entity.WriterEntity;
import java.util.Date;

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
