package com.example.course_service.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseRequestDto {
    private String name;
    private String department;
    private Integer durationInWeeks;
}
