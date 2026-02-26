package com.example.course_service.repo;

import com.example.course_service.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository  extends JpaRepository<Course,Integer> {
   Optional<Course>findByName(String name);
}
