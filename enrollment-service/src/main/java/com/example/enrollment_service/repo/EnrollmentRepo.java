package com.example.enrollment_service.repo;

import com.example.enrollment_service.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer> {
}
