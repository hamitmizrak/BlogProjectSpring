package com.hamitmizrak.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//1
@Getter @Setter
@Entity
@Table( name = "writer")
public class WriterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long writerId;

    public WriterEntity() {

    }

    //relation
    @OneToMany(mappedBy = "writerEntity", cascade = CascadeType.ALL)
    private List<BookEntity> bookEntityList;

    private String writerName;
    private String writerSurname;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;


}
