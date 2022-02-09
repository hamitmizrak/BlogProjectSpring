package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.business.dto.BookDto;
import com.hamitmizrak.business.dto.BookListDto;
import com.hamitmizrak.business.services.BookService;
import com.hamitmizrak.data.entity.BookEntity;
import com.hamitmizrak.data.entity.WriterEntity;
import com.hamitmizrak.data.repository.BookRepository;
import com.hamitmizrak.data.repository.WriterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository; //N

    @Autowired
    private WriterRepository writerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(BookDto bookDto) {
        BookEntity bookEntity = modelMapper.map(bookDto, BookEntity.class);
        if (bookDto.getWriterId() != 0) {
            Optional<WriterEntity> writerEntity = writerRepository.findById(bookDto.getWriterId());
            if (writerEntity.isPresent()) {
                bookEntity.setWriterEntity(writerEntity.get());
            }
        }

        bookRepository.save(bookEntity);
        bookEntity.setBookId(bookEntity.getBookId());
    }

    @Override
    public void update(BookDto bookDto) {
        BookEntity bookEntity = modelMapper.map(bookDto, BookEntity.class);
        if (bookDto.getWriterId() != 0) {
            Optional<WriterEntity> writerEntity = writerRepository.findById(bookDto.getWriterId());
            if (writerEntity.isPresent()) {
                bookEntity.setWriterEntity(writerEntity.get());
            }
        }

        bookRepository.save(bookEntity);
        bookEntity.setBookId(bookEntity.getBookId());
    }

    @Override
    public void delete(BookDto bookDto) {
        bookRepository.deleteById(bookDto.getBookId());
    }

    @Override
    public BookDto find(Long bookId) {

        Optional<BookEntity> optional = bookRepository.findById(bookId);

        BookDto bookDto = modelMapper.map(bookEntity, BookDto.class);
        BookEntity bookEntity = new BookEntity();
        if (bookEntity.getWriterEntity() != null) {
            bookDto.setWriterId(bookEntity.getWriterEntity().getWriterId());
            bookDto.setWriterName(bookEntity.getWriterEntity().getWriterName());
        }

        return null;
    }

    @Override
    public BookListDto list() {
        return null;
    }

    @Override
    public BookListDto listByWriter(Long writerId) {
        return null;
    }

    @Override
    public int countByWriter(Long writerId) {
        return 0;
    }
}
