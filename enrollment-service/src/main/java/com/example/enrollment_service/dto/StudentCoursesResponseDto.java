package com.example.enrollment_service.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCoursesResponseDto {
    private StudentResponseDto studentResponseDto;
    List<CourseResponseDto>courses;
}
