package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<TeacherEntity,Long> {

}
