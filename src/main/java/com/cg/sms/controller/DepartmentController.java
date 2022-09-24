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

import com.cg.sms.entity.Department;

import com.cg.sms.service.DepartmentService;


@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;//DependencyInjection
	
	@Validated
	@PostMapping("/addDepartments")
	public ResponseEntity<Department> saveDepartment(@RequestBody@Valid Department department) {
		Department departmentData= departmentService.saveDepartment(department);
		return new ResponseEntity<>(departmentData,HttpStatus.CREATED);
	}
	
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllStudents(){
		List<Department> departments=departmentService.getAllDepartments();
		return new ResponseEntity<>(departments,HttpStatus.OK);
	}
	@GetMapping("/departments/{department_id}")
	public ResponseEntity<Department> getStudent(@PathVariable Long department_id){
		Department department=departmentService.getDepartment(department_id);
		return new ResponseEntity<>(department,HttpStatus.OK);
	}
	@Validated
	@PutMapping("/updatedepartments/{department_id}")
	public ResponseEntity<Department> updateDepartment(@RequestBody@Valid Department department,@PathVariable Long department_id){
		Department updateddepartment=departmentService.updateDepartment(department, department_id);
		return new ResponseEntity<>(updateddepartment,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletedepartments/{department_id}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable Long department_id){
		departmentService.deleteDepartment(department_id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
