package com.bek.cement2.entity;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bek.cement2.repository.UserRepository;

@Service
public class UserInit implements CommandLineRunner{

	@Autowired
	UserRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public void run(String... args) throws Exception {

		this.repo.deleteAll();

		 User u1 = new User("admin",passwordEncoder.encode("admin"),"ACCOUNT","");

	        List<User> users = Arrays.asList(u1);
	        
	        this.repo.saveAll(users);

		
	}

}
