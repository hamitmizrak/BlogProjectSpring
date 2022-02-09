package com.hamitmizrak.business.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class BookListDto {

    List<BookDto> bookDtoList;

    //objenin kendisini kullanmadım bazen Objenin hepsini veriliyor sadece Id veya name lazım oluyor.
    //private WriterDto writerDto;
    private Long writerId;
    private String writerName;


}
