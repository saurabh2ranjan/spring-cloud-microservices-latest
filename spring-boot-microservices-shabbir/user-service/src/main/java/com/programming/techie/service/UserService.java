package com.programming.techie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.programming.techie.model.User;
import com.programming.techie.repository.UserRepository;
import com.programming.techie.vo.Department;
import com.programming.techie.vo.ResponseTemplateVo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DepartmentClient departmentClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Resilience4JCircuitBreakerFactory circuitBreakerFactory;

	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	// Using Traditional RestTemplate
	public ResponseTemplateVo getUserWithDepartment(Long userId) {
		User user = userRepository.findByUserId(userId);

		Department department = restTemplate
				.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

		ResponseTemplateVo vo = new ResponseTemplateVo();
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

	public ResponseTemplateVo getUserWithDepartmentWithFeign(Long userId) {
		User user = userRepository.findByUserId(userId);
		Department department = this.departmentClient.findDepartmentById(user.getDepartmentId());

		ResponseTemplateVo vo = new ResponseTemplateVo();
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

	@CircuitBreaker(name = "department", fallbackMethod = "fallbackMethodForDepartment")
	public ResponseTemplateVo getUserWithDepartmentWithFeignAndresilient4J(Long userId) {
		User user = userRepository.findByUserId(userId);
		Department department = this.departmentClient.findDepartmentById(user.getDepartmentId());

		ResponseTemplateVo vo = new ResponseTemplateVo();
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

	public ResponseTemplateVo fallbackMethodForDepartment(Long userId, Throwable t) {
		User user = userRepository.findByUserId(userId);
		ResponseTemplateVo vo = new ResponseTemplateVo();
		vo.setUser(user);
		vo.setDepartment(Department.builder().departmentId(1l).departmentName("Dummy").departmentAddress("Dummy")
				.departmentCode("Dummy").build());
		return vo;
	}
}
