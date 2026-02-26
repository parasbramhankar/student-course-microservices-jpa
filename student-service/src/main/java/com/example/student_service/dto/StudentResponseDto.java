package com.example.student_service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    private Integer id;
    private String name;
    private String email;
    private LocalDate dob;
}
