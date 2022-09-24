package com.cg.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystem {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystem.class, args);
	    
	}

}
//http://localhost:9090/api/v1/students
//http://localhost:9090/api/v1/addStudents
//http://localhost:9090/api/v1/students/1
//http://localhost:9090/api/v1/deleteStudents
//http://localhost:9090/api/v1/updateStudents
//http://localhost:9090/swagger-ui/index.html
