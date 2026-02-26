package com.example.course_service.service.impl;

import com.example.course_service.dto.CourseRequestDto;
import com.example.course_service.dto.CourseResponseDto;
import com.example.course_service.entity.Course;
import com.example.course_service.exception.CourseNotFoundException;
import com.example.course_service.mapper.CourseMapper;
import com.example.course_service.repo.CourseRepository;
import com.example.course_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseMapper courseMapper;

    public CourseResponseDto getCourseById(Integer id){
        Course course=courseRepository.findById(id).orElseThrow(()->
                new CourseNotFoundException("Course not found"));

        return courseMapper.mapToResponseDto(course);
    }

    public CourseResponseDto getCourseByName(String name){
        Course course=courseRepository.findByName(name).orElseThrow(()->
                new CourseNotFoundException("Course not found"));
        return courseMapper.mapToResponseDto(course);
    }
    public List<CourseResponseDto> getAllCourse(){
        List<Course>courseList=courseRepository.findAll();
        List<CourseResponseDto>courseResponseDtoList=new ArrayList<>();
        for(Course course:courseList){
            courseResponseDtoList.add(courseMapper.mapToResponseDto(course));
        }
        return courseResponseDtoList;
    }

    //Post
    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto){
        Course course=new Course();
        course.setName(courseRequestDto.getName());
        course.setDepartment(courseRequestDto.getDepartment());
        course.setDurationInWeeks(courseRequestDto.getDurationInWeeks());

        Course saveCourse=courseRepository.save(course);
        return courseMapper.mapToResponseDto(saveCourse);
    }

    //put
    public CourseResponseDto updateCourse(Integer id,CourseRequestDto courseRequestDto){
        Course course=courseRepository.findById(id).orElseThrow(()->
                new CourseNotFoundException("Course not found"));

        course.setName(courseRequestDto.getName());
        course.setDepartment(courseRequestDto.getDepartment());
        course.setDurationInWeeks(courseRequestDto.getDurationInWeeks());

        Course saveCourse=courseRepository.save(course);
        return courseMapper.mapToResponseDto(saveCourse);

    }

    //Patch
    public CourseResponseDto updateDurationInWeeks(Integer id,Integer durationInWeeks){
        Course course=courseRepository.findById(id).orElseThrow(()->
                new CourseNotFoundException("Course not found"));

        course.setDurationInWeeks(durationInWeeks);

        Course saveCourse=courseRepository.save(course);
        return courseMapper.mapToResponseDto(saveCourse);
    }

    //Delete
    public void deleteCourse(Integer id){
        Course course=courseRepository.findById(id).orElseThrow(()->
                new CourseNotFoundException("Course not found"));

        courseRepository.delete(course);
    }

}
