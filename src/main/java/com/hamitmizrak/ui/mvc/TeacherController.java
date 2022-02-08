package com.hamitmizrak.ui.mvc;

import com.hamitmizrak.business.dto.TeacherDto;
import com.hamitmizrak.business.services.TeacherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Log4j2
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    // CREATE
    // http://localhost:8080/create/teacher
    @GetMapping(path = {"/create/teacher", "/create/teacher/{id}"})
    public String createGetTeacher(Model model, @PathVariable(value = "id", required = false) Long id) {
        TeacherDto teacherDto=null;
        if(id==null){
            teacherDto =teacherService.find(0L);
        }else{
            teacherDto =teacherService.find(id);
        }
        model.addAttribute("key_teacher", teacherDto);
        return "/teacheradd";
    }

    // http://localhost:8080/create/teacher
    @PostMapping(path = {"/create/teacher", "/create/teacher/{id}"})
    public String createPostTeacher(@Valid @ModelAttribute("key_teacher") TeacherDto teacherDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/teacheradd";
        }
        log.info(teacherDto);
        teacherService.save(teacherDto);
        model.addAttribute("eklendi", "Eklendi");
        Iterable<TeacherDto> teacherDtoList = teacherService.list();
        model.addAttribute("key_teacher_list", teacherDtoList);
        return "/teacherlist";
    }

    //LIST
    // http://localhost:8080/list/teacher
    @GetMapping("/list/teacher")
    public String listGetTeacher(Model model) {
        Iterable<TeacherDto> teacherDtoList = teacherService.list();
        model.addAttribute("key_message", "Merhabalar List");
        model.addAttribute("key_teacher_list", teacherDtoList);
        return "/teacherlist";
    }

    //DELETE
    // http://localhost:8080/delete/teacher/1
    @GetMapping("/delete/teacher/{id}")
    public String deleteTeacher(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("silindi", "Teacher silindi");
        teacherService.delete(id);
        Iterable<TeacherDto> teacherDtoList = teacherService.list();
        model.addAttribute("key_teacher_list", teacherDtoList);
        return "/teacherlist";
    }
}
