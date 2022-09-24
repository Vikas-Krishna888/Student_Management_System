package com.cg.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.sms.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
	
}
