package com.programming.techie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programming.techie.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByDepartmentId(Long departmentId);
}
