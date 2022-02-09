package com.hamitmizrak.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Builder

//N
@Entity
@Table(name = "book")
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    public BookEntity() {
    }

    public BookEntity(Long bookId, String bookName, double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        Price = price;
    }

    //Relation
    @ManyToOne
    @JoinColumn(name = "writerId")
    private WriterEntity writerEntity;

    private String bookName;
    private double Price;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;
}
