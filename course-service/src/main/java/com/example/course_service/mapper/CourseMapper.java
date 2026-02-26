package com.example.course_service.mapper;

import com.example.course_service.dto.CourseResponseDto;
import com.example.course_service.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseResponseDto mapToResponseDto(Course course){
        CourseResponseDto courseResponseDto=new CourseResponseDto();

        courseResponseDto.setId(course.getId());
        courseResponseDto.setName(course.getName());
        courseResponseDto.setDepartment(course.getDepartment());
        courseResponseDto.setDurationInWeeks(course.getDurationInWeeks());

        return courseResponseDto;
    }
}
