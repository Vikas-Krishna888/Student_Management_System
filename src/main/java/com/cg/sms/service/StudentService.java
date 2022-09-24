package com.cg.sms.service;

import java.util.List;

import com.cg.sms.entity.Student;

public interface StudentService {
	public Student saveStudent(Student student,Long department_id);
	
	List<Student> getAllStudents();
	
	Student getStudent(Long studentId);
	
	Student updateStudent(Student student,Long student_id);
	
	void deleteStudent(Long student_id);
}
