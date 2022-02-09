package com.hamitmizrak.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Builder

//1
@Entity
@Table( name = "writer")
public class WriterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long writerId;

    //relation
    @OneToMany(mappedBy = "writerEntity", cascade = CascadeType.ALL)
    private List<BookEntity> bookEntityList;

    private String writerName;
    private String writerSurname;
}
