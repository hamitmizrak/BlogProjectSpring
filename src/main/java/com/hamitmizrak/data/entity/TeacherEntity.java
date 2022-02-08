package com.hamitmizrak.data.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

@Entity
@Table(name = "teacher")
//@Valid @NotEmpty(message="")  @Email(message="") @Min(message"" value="")
public class TeacherEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "teacher_name")
    @NotEmpty(message = "adı alanını boş geçemezsiniz")
    @Size(message = "en fazla 40 karakter girebilirsiniz",min = 1,max = 40)
    private String teacherName;

    @Column(name = "teacher_price")
    @Min(message = "4500 altında yazamazsınız",value = 4500)
    @Max(message = "12000 üstünde yazamazsınız",value = 12000)
    private double teacherPrice;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;
}
