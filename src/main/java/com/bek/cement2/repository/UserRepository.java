package com.bek.cement2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bek.cement2.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username); 

}
