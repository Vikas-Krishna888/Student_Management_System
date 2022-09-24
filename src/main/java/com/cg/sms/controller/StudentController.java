package com.cg.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cg.sms.entity.Student;
import com.cg.sms.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	StudentService studentService;//DependencyInjection
	
	@Validated
	@PostMapping("/departments/{department_id}/students")
	public ResponseEntity<Student> saveStudent(@Valid@RequestBody Student student,@PathVariable Long department_id) {
		Student studentData= studentService.saveStudent(student,department_id);
		return new ResponseEntity<>(studentData,HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students=studentService.getAllStudents();
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	@GetMapping("/students/{student_id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long student_id){
		Student student=studentService.getStudent(student_id);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	@Validated
	@PutMapping("/updateStudents/{student_id}")
	public ResponseEntity<Student> updateStudent(@Valid@RequestBody Student student,@PathVariable Long student_id){
		Student updatedStudent=studentService.updateStudent(student,student_id);
		return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudents/{student_id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Long student_id){
		studentService.deleteStudent(student_id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
