package com.hamitmizrak.ui.mvc;

import com.hamitmizrak.data.entity.TeacherEntity;
import com.hamitmizrak.data.repository.TeacherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Log4j2
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    // CREATE
    // http://localhost:8080/create/teacher
    @GetMapping(path = {"/create/teacher", "/create/teacher/{id}"})
    public String createGetTeacher(Model model, @PathVariable(value = "id", required = false) Long id) {
        TeacherEntity teacherEntity;
        if (id == null) {
            teacherEntity = TeacherEntity
                    .builder()
                    .teacherId(0L)
                    .teacherName("adınız")
                    .teacherPrice(0)
                    .build();
        } else {
            Optional<TeacherEntity> optional = teacherRepository.findById(id);
            if (optional.isPresent()) {
                teacherEntity = optional.get();
            } else {
                teacherEntity = TeacherEntity
                        .builder()
                        .teacherId(0L)
                        .teacherName("adınız")
                        .teacherPrice(0)
                        .build();
            }
        }
        model.addAttribute("key_teacher", teacherEntity);
        return "/teacheradd";
    }

    // http://localhost:8080/create/teacher
    @PostMapping(path = {"/create/teacher", "/create/teacher/{id}"})
    public String createPostTeacher(@Valid @ModelAttribute("key_teacher") TeacherEntity teacherEntity, @PathVariable(value = "id", required = false) Long id, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/teacheradd";
        }
        log.info(teacherEntity);
        teacherRepository.save(teacherEntity);
        model.addAttribute("eklendi", "Eklendi");
        Iterable<TeacherEntity> teacherList = teacherRepository.findAll();
        model.addAttribute("key_teacher_list", teacherList);
        return "/teacherlist";
    }

    //LIST
    // http://localhost:8080/list/teacher
    @GetMapping("/list/teacher")
    public String listGetTeacher(Model model) {
        Iterable<TeacherEntity> teacherList = teacherRepository.findAll();
        model.addAttribute("key_message", "Merhabalar List");
        model.addAttribute("key_teacher_list", teacherList);
        return "/teacherlist";
    }

    //DELETE
    // http://localhost:8080/delete/teacher/1
    @GetMapping("/delete/teacher/{id}")
    public String deleteTeacher(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("silindi", "Teacher silindi");
        teacherRepository.deleteById(id);
        Iterable<TeacherEntity> teacherList = teacherRepository.findAll();
        model.addAttribute("key_teacher_list", teacherList);
        return "/teacherlist";
    }
}
