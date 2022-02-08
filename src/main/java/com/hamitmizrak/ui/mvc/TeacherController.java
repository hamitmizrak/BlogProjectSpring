package com.hamitmizrak.ui.mvc;

import com.hamitmizrak.data.entity.TeacherEntity;
import com.hamitmizrak.data.repository.TeacherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Log4j2
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

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
