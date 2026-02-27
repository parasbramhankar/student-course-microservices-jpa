package com.example.enrollment_service.service.impl;

import com.example.enrollment_service.dto.*;
import com.example.enrollment_service.entity.Enrollment;
import com.example.enrollment_service.exception.EnrollmentNotFoundException;
import com.example.enrollment_service.mapper.Mapper;
import com.example.enrollment_service.repo.CourseApiClient;
import com.example.enrollment_service.repo.EnrollmentRepo;
import com.example.enrollment_service.repo.StudentApiClient;
import com.example.enrollment_service.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    EnrollmentRepo enrollmentRepo;

    @Autowired
    Mapper mapper;

    @Autowired
    StudentApiClient studentApiClient;

    @Autowired
    CourseApiClient courseApiClient;

    public EnrollmentResponseDto enrollStudent(EnrollmentRequestDto requestDto){
        Enrollment enrollment=new Enrollment();
        enrollment.setStudentId(requestDto.getStudentId());
        enrollment.setCourseId(requestDto.getCourseId());
        enrollment.setEnrollmentDate(requestDto.getEnrollmentDate());

        Enrollment save=enrollmentRepo.save(enrollment);

        return mapper.mapToEnrollmentResponseDto(save);
    }

    public List<EnrollmentResponseDto> getAllEnrollments(){
        List<Enrollment>list=enrollmentRepo.findAll();

        List<EnrollmentResponseDto>enrollmentResponseDtos=new ArrayList<>();

        for(Enrollment e:list){
            EnrollmentResponseDto enrollmentResponseDto=mapper.mapToEnrollmentResponseDto(e);
            enrollmentResponseDtos.add(enrollmentResponseDto);
        }

        return enrollmentResponseDtos;
    }

    public StudentCoursesResponseDto getStudentWithCourses(Integer studentId){

        //using feign
        StudentResponseDto student = studentApiClient.getStudentById(studentId);


        List<Enrollment> enrollments = enrollmentRepo.findByStudentId(studentId);

// Get all enrollments for that student
        List<CourseResponseDto> courses = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {

            //using Feign
            CourseResponseDto course = courseApiClient.getCourseById(enrollment.getCourseId());
            courses.add(course);
        }

// Combine and return
        StudentCoursesResponseDto response = new StudentCoursesResponseDto();

        response.setStudentResponseDto(student);
        response.setCourses(courses);

        return response;
    }

    public void deleteEnrollment(Integer id){
        Enrollment enrollment=enrollmentRepo.findById(id).orElseThrow(()->new EnrollmentNotFoundException("Enrollment not found with id: " + id));
        enrollmentRepo.delete(enrollment);
    }

}
