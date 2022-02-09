package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.WriterDto;
import com.hamitmizrak.business.dto.WriterListDto;

public interface WriterService {

    public void create(WriterDto writerDto);
    public void update(WriterDto writerDto);
    public void delete(WriterDto writerDto);
    public void find(Long writerDto);
    public WriterListDto listDto();

    //Book
    public WriterListDto listByBook(Long bookId);
    public Long countByBook(Long bookId);

}
