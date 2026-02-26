package com.example.course_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {
    private Integer id;
    private String name;
    private String department;
    private Integer durationInWeeks;
}
