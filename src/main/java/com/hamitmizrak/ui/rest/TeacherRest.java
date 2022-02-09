package com.hamitmizrak.ui.rest;

import com.hamitmizrak.business.dto.TeacherDto;
import com.hamitmizrak.business.services.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/teacher")
@Api(value = "Teacher Api document")//swagger
public class TeacherRest {

    // http://localhost:8080/swagger-ui.html
    //Swagger
    //@Api
    //@ApiModel
    //@ApiModelProperty
    //@ApiOperation
    //@ApiParam
    //@ApiResponse
    //@ApiResponses


    @Autowired
    private TeacherService teacherService;

    //GET
    // http://localhost:8080/rest/get/teacher/1
    @ApiOperation(value = "Get Örneği ID",notes = "get metodu aman dikkat") //Swagger
    @GetMapping("/rest/get/teacher/{id}")
    public TeacherDto selectRestTeacher(@PathVariable(value = "id") Long id) {
        TeacherDto teacherDto = teacherService.find(id);
        return teacherDto;
    }


    //GET LIST
    // http://localhost:8080/rest/get/teacher/list
    @ApiOperation(value = "Get Örneği LIST",notes = "list metodu aman dikkat") //Swagger
    @GetMapping("/rest/get/teacher/list")
    public List<TeacherDto> selectRestTeacherList() {
        List<TeacherDto> teacherDto = teacherService.list();
        return teacherDto;
    }

    //POST
    // http://localhost:8080/rest/post/teacher
    @ApiOperation(value = "Post Örneği",notes = "post metodu aman dikkat") //Swagger
    @PostMapping(path = "/rest/post/teacher")
    public TeacherDto postRestTeacher(TeacherDto teacherDto) {
        teacherService.save(teacherDto);
        return teacherDto;
    }

    //PUT
    // http://localhost:8080/rest/put/teacher
    @ApiOperation(value = "PUT Örneği",notes = "güncelleme metodu aman dikkat") //Swagger
    @PutMapping("/rest/put/teacher")
    public void updateRestTeacher(TeacherDto teacherDto) {
        teacherService.save(teacherDto);
    }

    //DELETE
    // http://localhost:8080/rest/delete/49
    @ApiOperation(value = "DELETE Örneği",notes = "silme metodu aman dikkat") //Swagger
    @DeleteMapping("/rest/delete/{id}")
    public void deleteRestTeacher(@PathVariable(value = "id") Long id) {
        teacherService.delete(id);
    }

}
