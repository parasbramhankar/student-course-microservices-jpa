package com.example.student_course_admin_server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class StudentCourseAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCourseAdminServerApplication.class, args);
	}

}
