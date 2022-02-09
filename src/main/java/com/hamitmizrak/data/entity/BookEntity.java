package com.hamitmizrak.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter @Getter
@Builder

//N
@Entity
@Table(name = "book")
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    //Relation
    @ManyToOne
    @JoinColumn(name = "writerId")
    private WriterEntity writerEntity;

    private String bookName;
    private double Price;
}
