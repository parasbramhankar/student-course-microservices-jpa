package com.example.enrollment_service.mapper;

import com.example.enrollment_service.dto.EnrollmentResponseDto;
import com.example.enrollment_service.dto.StudentCoursesResponseDto;
import com.example.enrollment_service.entity.Enrollment;

import java.time.LocalDate;

public class Mapper {

    public EnrollmentResponseDto mapToEnrollmentResponseDto(Enrollment enrollment){
        EnrollmentResponseDto dto = new EnrollmentResponseDto();

        dto.setId(enrollment.getId());
        dto.setStudentId(enrollment.getStudentId());
        dto.setCourseId(enrollment.getCourseId());
        dto.setEnrollmentDate(enrollment.getEnrollmentDate());

        return dto;
    }

//    public StudentCoursesResponseDto mapToStudentCoursesResponseDto(){
//
//    }

}
