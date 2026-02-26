package com.example.student_service.controller;

import com.example.student_service.dto.StudentRequestDto;
import com.example.student_service.dto.StudentResponseDto;
import com.example.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/getstudent/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping("/getstudents")
    public ResponseEntity<List<StudentResponseDto>>getAllStudents(){
        List<StudentResponseDto>studentResponseDtoList=service.getAllStudents();
        return ResponseEntity.ok(studentResponseDtoList);
    }

    @PostMapping("/create")
    public ResponseEntity<StudentResponseDto>saveStudent(@RequestBody StudentRequestDto studentRequestDto){

        return ResponseEntity.ok(service.saveStudent(studentRequestDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponseDto>updateStudent(@PathVariable Integer id,@RequestBody StudentRequestDto studentRequestDto){
        return ResponseEntity.ok(service.updateStudent(id,studentRequestDto));
    }

    @PatchMapping("/updatedob/{id}")
    public ResponseEntity<StudentResponseDto>updateDob(@PathVariable Integer id, @RequestBody LocalDate date){
        return ResponseEntity.ok(service.updateDob(id,date));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        service.deleteStudent(id);

        return ResponseEntity.ok("Student deleted successfully");
    }
}
