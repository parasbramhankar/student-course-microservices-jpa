package com.example.student_service.mapper;

import com.example.student_service.dto.StudentResponseDto;
import com.example.student_service.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentResponseDto mapToStudentResponseDto(Student student){
        StudentResponseDto studentResponseDto=new StudentResponseDto();

        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setDob(student.getDob());

        return studentResponseDto;
    }
}
