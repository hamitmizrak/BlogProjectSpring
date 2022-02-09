package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.BookDto;
import com.hamitmizrak.business.dto.BookListDto;
import com.hamitmizrak.business.dto.WriterListDto;

//N
public interface BookService    {

    public void create(BookDto bookDto);
    public void update(BookDto bookDto);
    public void delete(BookDto bookDto);
    public BookDto find(Long bookId);


    public BookListDto list();
    public BookListDto listByWriter(Long writerId);
    public int  countByWriter(Long writerId);


}
