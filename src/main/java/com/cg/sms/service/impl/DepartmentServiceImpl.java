package com.cg.sms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sms.entity.Department;

import com.cg.sms.exception.DepartmentNotFoundException;

import com.cg.sms.repository.DepartmentRepository;
import com.cg.sms.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartment(Long department_id) {
		Department department=departmentRepository.findById(department_id).orElseThrow(()->new DepartmentNotFoundException("No Department Found with id :"+department_id));
		return department;
	}

	@Override
	public Department updateDepartment(Department department, Long department_id) {
		Optional<Department> departmentOpt=departmentRepository.findById(department_id);
		if( departmentOpt.isPresent()) {
			Department departmentInfo= departmentOpt.get();
			departmentInfo.setName(department.getName());
			departmentInfo.setDepartmentHeadName(department.getDepartmentHeadName());
			departmentInfo.setPhoneNumber(department.getPhoneNumber());
			return departmentRepository.save(departmentInfo);
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteDepartment(Long department_id) {
		Department department=departmentRepository.findById(department_id).orElseThrow(()->new DepartmentNotFoundException("No Department Found with id :"+department_id));
		departmentRepository.deleteById(department_id);
	}
	

}
