package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository  extends JpaRepository<TeacherEntity,Long> {

}
