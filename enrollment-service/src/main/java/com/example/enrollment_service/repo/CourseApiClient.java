package com.example.enrollment_service.repo;

import com.example.enrollment_service.dto.CourseResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseApiClient {

    @GetMapping("/course/{id}")
    CourseResponseDto getCourseById(@PathVariable Integer id);

}
