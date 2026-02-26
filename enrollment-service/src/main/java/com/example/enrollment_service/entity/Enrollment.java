package com.example.enrollment_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "enrollment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer student_id;

    @Column(nullable = false)
    private Integer course_id;

    private LocalDate enrollmentDate;

}
