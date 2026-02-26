package com.example.course_service.controller;

import com.example.course_service.dto.CourseRequestDto;
import com.example.course_service.dto.CourseResponseDto;
import com.example.course_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

//Get
    @GetMapping("/{id}")
    ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Integer id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("/name/{name}")
    ResponseEntity<CourseResponseDto> getCourseByName(@PathVariable String name){
        CourseResponseDto courseResponseDto=courseService.getCourseByName(name);

        return ResponseEntity.ok(courseResponseDto);
    }

    @GetMapping("/allcourses")
    ResponseEntity<List<CourseResponseDto>> getAllCourse(){
        return ResponseEntity.ok(courseService.getAllCourse());
    }

    //Post
    @PostMapping("/createcourse")
    ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto courseRequestDto){
        return ResponseEntity.ok(courseService.createCourse(courseRequestDto));
    }

    //put
    @PutMapping("/update/{id}")
    ResponseEntity<CourseResponseDto>updateCourse(@PathVariable Integer id,@RequestBody CourseRequestDto courseRequestDto){
        return ResponseEntity.ok(courseService.updateCourse(id,courseRequestDto));
    }

    //Patch
    @PatchMapping("/updateduration/{id}")
    ResponseEntity<CourseResponseDto>updateDurationInWeeks(@PathVariable int id, @RequestBody Integer durationInWeeks){
        return ResponseEntity.ok(courseService.updateDurationInWeeks(id,durationInWeeks));
    }

    //Delete
    @DeleteMapping("/deletecourse/{id}")
    ResponseEntity<String> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);

        return ResponseEntity.ok("Course deleted successfully");
    }

}
