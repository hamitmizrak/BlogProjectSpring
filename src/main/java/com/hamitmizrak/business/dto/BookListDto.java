package com.hamitmizrak.business.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class BookListDto {

    List<BookDto> bookDtoList;
    private Long writerId;
    private String writerName;


}
