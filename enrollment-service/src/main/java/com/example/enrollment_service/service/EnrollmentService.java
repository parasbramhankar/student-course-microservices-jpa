package com.example.enrollment_service.service;

import com.example.enrollment_service.dto.EnrollmentRequestDto;
import com.example.enrollment_service.dto.EnrollmentResponseDto;
import com.example.enrollment_service.dto.StudentCoursesResponseDto;

import java.util.List;

public interface EnrollmentService {

    EnrollmentResponseDto enrollStudent(EnrollmentRequestDto requestDto);

    List<EnrollmentResponseDto> getAllEnrollments();

    StudentCoursesResponseDto getStudentWithCourses(Integer id);

    void deleteEnrollment(Integer id);
}
