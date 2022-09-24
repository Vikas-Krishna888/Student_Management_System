package com.cg.sms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sms.entity.Department;
import com.cg.sms.entity.Student;
import com.cg.sms.exception.DepartmentNotFoundException;
import com.cg.sms.exception.StudentNotFoundException;
import com.cg.sms.repository.DepartmentRepository;
import com.cg.sms.repository.StudentRepository;
import com.cg.sms.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public Student saveStudent(Student student, Long department_id) {
		Optional<Department> departmentOpt=departmentRepository.findById(department_id);
		if(departmentOpt.isPresent()) {
			Department department=departmentOpt.get();
			department.setId(department_id);
			student.setDepartment(department);
			return studentRepository.save(student);
		}
		else {
			throw new DepartmentNotFoundException("Department not found");
		}
		
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(Long student_id) {
		Student student=studentRepository.findById(student_id).orElseThrow(()->new StudentNotFoundException("No Student Found with id :"+student_id));
		return student;
	}

	@Override
	public Student updateStudent(Student student, Long student_id) {
		/*Optional<Student> studentOpt=studentRepository.findById(student_id);
		if(studentOpt.isPresent()) {
			Student studentInfo=studentOpt.get();*/
		Student studentInfo=studentRepository.findById(student_id).orElseThrow(()->new StudentNotFoundException("No Student Found with id :"+student_id));
			studentInfo.setFirstName(student.getFirstName());
			studentInfo.setLastName(student.getLastName());
			studentInfo.setEmail(student.getEmail());
			//studentInfo.setDepartmentName(student.getDepartmentName());
			studentInfo.setPhoneNumber(student.getPhoneNumber());
			 studentRepository.save(studentInfo);
			 return studentInfo;
		/*}
		else {
			throw new StudentNotFoundException("No Student Found with id :"+student_id);
		}*/
	}

	@Override
	public void deleteStudent(Long student_id) {
		Student student=studentRepository.findById(student_id).orElseThrow(()->new StudentNotFoundException("No Student Found with id :"+student_id));
		studentRepository.deleteById(student_id);
		
	}


	
	
}


