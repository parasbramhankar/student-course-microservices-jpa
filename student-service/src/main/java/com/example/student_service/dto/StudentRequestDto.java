package com.example.student_service.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentRequestDto {
    private String name;
    private String email;
    private LocalDate dob;
}
