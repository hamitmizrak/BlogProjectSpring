package com.hamitmizrak.business.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

//@Valid @NotEmpty(message="")  @Email(message="") @Min(message"" value="")
public class TeacherDto {
    private Long teacherId;

    @NotEmpty(message = "adı alanını boş geçemezsiniz")
    @Size(message = "en fazla 40 karakter girebilirsiniz",min = 1,max = 40)
    private String teacherName;

    @Min(message = "4500 altında yazamazsınız",value = 4500)
    @Max(message = "12000 üstünde yazamazsınız",value = 12000)
    private double teacherPrice;

    private Date date;
}
