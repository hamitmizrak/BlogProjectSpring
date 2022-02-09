package com.hamitmizrak.business.dto;

import java.util.List;

public class WriterListDto {

    List<WriterDto> writerDtoList;

    //objenin kendisini kullanmadım bazen Objenin hepsini veriliyor sadece Id veya name lazım oluyor.
    //private BookDto bookDto;
    private Long bookId;
    private String bookName;

}
