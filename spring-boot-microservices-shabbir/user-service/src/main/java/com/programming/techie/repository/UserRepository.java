package com.programming.techie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programming.techie.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserId(Long userId);
}
