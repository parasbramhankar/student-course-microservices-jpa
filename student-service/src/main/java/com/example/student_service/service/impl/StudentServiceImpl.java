package com.example.student_service.service.impl;


import com.example.student_service.dto.StudentRequestDto;
import com.example.student_service.dto.StudentResponseDto;
import com.example.student_service.entity.Student;
import com.example.student_service.exception.StudentNotFoundException;
import com.example.student_service.mapper.StudentMapper;
import com.example.student_service.repo.StudentRepo;
import com.example.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentMapper mapper;

    public StudentResponseDto getStudentById(Integer id){
        Student student=studentRepo.findById(id).orElseThrow(()->
                new StudentNotFoundException("Student not Found"));

        return mapper.mapToStudentResponseDto(student);
    }
    public List<StudentResponseDto> getAllStudents(){
        List<Student>students=studentRepo.findAll();

        List<StudentResponseDto>studentResponseDtos=new ArrayList<>();

        for(Student student:students){
            StudentResponseDto s=mapper.mapToStudentResponseDto(student);
            studentResponseDtos.add(s);
        }

        return studentResponseDtos;
    }

    public StudentResponseDto saveStudent(StudentRequestDto studentRequestDto){
        Student student=new Student();

        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setDob(studentRequestDto.getDob());

        Student saveStudent=studentRepo.save(student);

        return mapper.mapToStudentResponseDto(saveStudent);
    }

    public StudentResponseDto updateStudent(Integer id, StudentRequestDto studentRequestDto){
        Student student=studentRepo.findById(id).orElseThrow(()->
                new StudentNotFoundException("Student not found"));

        student.setName(studentRequestDto.getName());
        student.setDob(studentRequestDto.getDob());
        student.setEmail(studentRequestDto.getEmail());

        Student saveStudent=studentRepo.save(student);

        return mapper.mapToStudentResponseDto(saveStudent);
    }

    public StudentResponseDto updateDob(Integer id, LocalDate dob){
        Student student=studentRepo.findById(id).orElseThrow(()->
                new StudentNotFoundException("Student not found"));

        student.setDob(dob);

        return mapper.mapToStudentResponseDto(student);
    }

    public void deleteStudent(Integer id){
        Student student=studentRepo.findById(id).orElseThrow(()->
                new StudentNotFoundException("Student not found"));

        studentRepo.delete(student);
    }
}
