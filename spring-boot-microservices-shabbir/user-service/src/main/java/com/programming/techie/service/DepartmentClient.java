package com.programming.techie.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.programming.techie.vo.Department;

@FeignClient(name = "department-service")
public interface DepartmentClient {

	@ResponseBody
	@GetMapping("/departments/{id}")
	Department findDepartmentById(@PathVariable("id") Long departmentId);
}
