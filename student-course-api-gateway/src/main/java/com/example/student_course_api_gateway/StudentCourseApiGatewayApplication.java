package com.example.student_course_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class StudentCourseApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCourseApiGatewayApplication.class, args);
	}

}
