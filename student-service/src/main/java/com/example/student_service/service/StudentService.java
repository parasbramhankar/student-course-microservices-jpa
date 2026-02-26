package com.example.student_service.service;

import com.example.student_service.dto.StudentRequestDto;
import com.example.student_service.dto.StudentResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {

    StudentResponseDto getStudentById(Integer id);
    List<StudentResponseDto> getAllStudents();

    StudentResponseDto saveStudent(StudentRequestDto studentRequestDto);

    StudentResponseDto updateStudent(Integer id, StudentRequestDto studentRequestDto);
    StudentResponseDto updateDob(Integer id,LocalDate dob);

    void deleteStudent(Integer id);

}
