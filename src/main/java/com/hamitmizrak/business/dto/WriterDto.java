package com.hamitmizrak.business.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Builder
public class WriterDto {

    private Long writerId;
    private String writerName;
    private String writerSurname;
    private Date date;





}
