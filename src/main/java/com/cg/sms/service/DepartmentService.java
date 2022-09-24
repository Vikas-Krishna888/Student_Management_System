package com.cg.sms.service;

import java.util.List;

import com.cg.sms.entity.Department;
import com.cg.sms.exception.DepartmentNotFoundException;


public interface DepartmentService {

public Department saveDepartment(Department department);
	
	List<Department> getAllDepartments();
	
	Department getDepartment(Long department_id);
	
	Department updateDepartment(Department department,Long department_id);
	
	void deleteDepartment(Long department_id);
}
