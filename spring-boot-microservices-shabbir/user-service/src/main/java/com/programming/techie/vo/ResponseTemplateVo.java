package com.programming.techie.vo;

import lombok.NoArgsConstructor;

import com.programming.techie.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTemplateVo {

	private User user;
	private Department department;
}
