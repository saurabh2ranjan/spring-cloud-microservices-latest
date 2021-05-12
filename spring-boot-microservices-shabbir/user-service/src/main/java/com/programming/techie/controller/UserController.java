package com.programming.techie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.model.User;
import com.programming.techie.propertyaccess.PropertyAccessBean;
import com.programming.techie.propertyaccess.PropertyAccessValue;
import com.programming.techie.service.UserService;
import com.programming.techie.vo.ResponseTemplateVo;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {

	@Autowired
	private UserService userService; 
	
	@Autowired
	private PropertyAccessBean propertyAccessBean;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId) {
//		return userService.getUserWithDepartment(userId);
		
//		return userService.getUserWithDepartmentWithFeign(userId);
		
		return userService.getUserWithDepartmentWithFeignAndresilient4J(userId);
	}
	
	@GetMapping("/readKey")
	public PropertyAccessValue accessPropertyFiles() {
		return new PropertyAccessValue(propertyAccessBean.getName(), propertyAccessBean.getDescription());
	}
}
