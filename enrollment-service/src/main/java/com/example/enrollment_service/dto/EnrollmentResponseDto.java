package com.example.enrollment_service.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EnrollmentResponseDto {

    private Integer id;

    private Integer studentId;
    private Integer courseId;

    private LocalDate enrollmentDate;
}
