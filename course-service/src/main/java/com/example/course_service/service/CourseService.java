package com.example.course_service.service;

import com.example.course_service.dto.CourseRequestDto;
import com.example.course_service.dto.CourseResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface CourseService {

    //Get
    CourseResponseDto getCourseById(Integer id);
    CourseResponseDto getCourseByName(String name);
    List<CourseResponseDto> getAllCourse();

    //Post
    CourseResponseDto createCourse(CourseRequestDto courseRequestDto);

    //put
    CourseResponseDto updateCourse(Integer id,CourseRequestDto courseRequestDto);

    //Patch
    CourseResponseDto updateDurationInWeeks(Integer id,Integer durationInWeeks);

    //Delete
    void deleteCourse(Integer id);

}
