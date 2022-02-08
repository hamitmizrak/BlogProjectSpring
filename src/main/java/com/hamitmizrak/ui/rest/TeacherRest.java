package com.hamitmizrak.ui.rest;

import com.hamitmizrak.business.dto.TeacherDto;
import com.hamitmizrak.business.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherRest {

    @Autowired
    private TeacherService teacherService;

    //GET
    // http://localhost:8080/rest/get/teacher/1
    @GetMapping("/rest/get/teacher/{id}")
    public TeacherDto selectRestTeacher(@PathVariable(value = "id") Long id) {
        TeacherDto teacherDto = teacherService.find(id);
        return teacherDto;
    }


    //GET LIST
    // http://localhost:8080/rest/get/teacher/list
    @GetMapping("/rest/get/teacher/list")
    public List<TeacherDto> selectRestTeacherList() {
        List<TeacherDto> teacherDto = teacherService.list();
        return teacherDto;
    }

    //POST
    // http://localhost:8080/rest/post/teacher
    @PostMapping(path = "/rest/post/teacher")
    public TeacherDto postRestTeacher(TeacherDto teacherDto) {
        teacherService.save(teacherDto);
        return teacherDto;
    }

    //PUT
    // http://localhost:8080/rest/put/teacher
    @PutMapping("/rest/put/teacher")
    public void updateRestTeacher(TeacherDto teacherDto) {
        teacherService.save(teacherDto);
    }

    //DELETE
    // http://localhost:8080/rest/delete/49
    @DeleteMapping("/rest/delete/{id}")
    public void deleteRestTeacher(@PathVariable(value = "id") Long id) {
        teacherService.delete(id);
    }

}
