package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookRepository,Long> {

    //yazar ID Kitapları getirmek
    @Query("select b from BookEntity b where b.bookId= :bookId")
    public List<BookEntity> findByWriter(@Param("bookId") Long writerId);

    @Query("select count(b.bookId)  from BookEntity b where b.bookId= :bookId")
    public Long countByWriter(Long writerId);
}
