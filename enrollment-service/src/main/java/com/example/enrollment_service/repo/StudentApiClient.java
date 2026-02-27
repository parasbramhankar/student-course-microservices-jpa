package com.example.enrollment_service.repo;


import com.example.enrollment_service.dto.StudentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentApiClient {

    @GetMapping("/student/getstudent/{id}")
    StudentResponseDto getStudentById(@PathVariable Integer id);

}
