package com.hamitmizrak.ui.mvc;
import com.hamitmizrak.data.entity.TeacherEntity;
import com.hamitmizrak.data.repository.TeacherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    // http://localhost:8080/create/teacher
    @GetMapping("/create/teacher")
    public String createGetTeacher(Model model) {
        TeacherEntity teacherEntity = TeacherEntity
                .builder()
                .teacherId(0L)
                .teacherName("adınız")
                .teacherPrice(0)
                .build();
        model.addAttribute("key_teacher", teacherEntity);
        return "/teacherpage/teacher";
    }

    // http://localhost:8080/create/teacher
    @PostMapping("/create/teacher")
    public String createPostTeacher(@Valid @ModelAttribute("key_teacher") TeacherEntity teacherEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/teacherpage/teacher";
        }
        log.info(teacherEntity);
        teacherRepository.save(teacherEntity);
        return "success";
    }
}
