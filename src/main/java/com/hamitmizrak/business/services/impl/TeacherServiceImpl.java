package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.business.dto.TeacherDto;
import com.hamitmizrak.business.services.TeacherService;
import com.hamitmizrak.data.entity.TeacherEntity;
import com.hamitmizrak.data.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    private ModelMapper modelMapper;

    public TeacherServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //create
    @Override
    public void create(TeacherDto teacherDto) {
        TeacherEntity teacherEntity = DtoToEntity(teacherDto);//ModelMapper
        teacherRepository.save(teacherEntity);
    }

    //delete
    @Override
    public void delete(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }


    //find
    @Override
    public TeacherDto find(Long teacherId) {
        TeacherDto teacherDto = new TeacherDto();
        Optional<TeacherEntity> optional = teacherRepository.findById(teacherId);
        if (optional.isPresent()) {
            TeacherEntity teacherEntity = optional.get();
            teacherDto= EntityToDto(teacherEntity);//ModelMapper
        } else {
            teacherDto = TeacherDto
                    .builder()
                    .teacherId(0L)
                    .teacherName("adınız")
                    .teacherPrice(0)
                    .build();
        }
        return teacherDto;
    }

    //list
    @Override
    public List<TeacherDto> list() {
        List<TeacherDto> listDto = new ArrayList<>();
        Iterable<TeacherEntity> teacherList = teacherRepository.findAll();
        for (TeacherEntity entity : teacherList) {
            TeacherDto teacherDto = EntityToDto(entity);//model
            listDto.add(teacherDto);
        }
        return listDto;
    }

    //Dynamic modelMapper
    public TeacherDto EntityToDto(TeacherEntity entity){
        TeacherDto teacherDto=modelMapper.map(entity,TeacherDto.class);
        return teacherDto;
    }

    public TeacherEntity DtoToEntity(TeacherDto dto) {
        TeacherEntity teacherEntity=modelMapper.map(dto,TeacherEntity.class);
        return teacherEntity;
    }


//    // modelMapper yaptım
//    public void EntityToDto(TeacherEntity entity, TeacherDto dto) {
//        ////manuel modelMapper
//        //  dto.setTeacherId(entity.getTeacherId());
//        //  dto.setTeacherName(entity.getTeacherName());
//        //  dto.setTeacherPrice(entity.getTeacherPrice());
//    }
//
//    public void DtoToEntity(TeacherDto dto, TeacherEntity entity) {
//        ////manuel modelMapper
//        //  entity.setTeacherId(dto.getTeacherId());
//        //  entity.setTeacherName(dto.getTeacherName());
//        // entity.setTeacherPrice(dto.getTeacherPrice());
//    }

}
