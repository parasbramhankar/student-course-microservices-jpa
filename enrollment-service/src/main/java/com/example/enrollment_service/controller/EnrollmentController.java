package com.example.enrollment_service.controller;

import com.example.enrollment_service.dto.EnrollmentRequestDto;
import com.example.enrollment_service.dto.EnrollmentResponseDto;
import com.example.enrollment_service.dto.StudentCoursesResponseDto;
import com.example.enrollment_service.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

   @Autowired
   EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponseDto> enrollStudent(@RequestBody EnrollmentRequestDto request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentService.enrollStudent(request));
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDto>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentCoursesResponseDto> getStudentCourses(@PathVariable Integer studentId) {

        return ResponseEntity.ok(enrollmentService.getStudentWithCourses(studentId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Integer id) {

        enrollmentService.deleteEnrollment(id);

        return ResponseEntity.ok("Enrollment deleted successfully");
    }
}
