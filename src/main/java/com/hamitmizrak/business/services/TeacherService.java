package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    public void create(TeacherDto teacherDto);
    public void delete(Long teacherId);
    public TeacherDto find(Long teacherId);
    public List<TeacherDto> list();
}
