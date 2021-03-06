package com.programming.techie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programming.techie.model.Department;
import com.programming.techie.repository.DepartmentRepository;

import lombok.extern.java.Log;

@Service
@Log
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		log.info("Inside saveDepartment of DepartmentService");
		return departmentRepository.save(department);
	}
	
	public Department findDepartmentById(Long departmentId) {
		log.info("Inside findDepartmentById of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}
}
