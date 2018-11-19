package com.michelzarpelon.spring_boot_mongoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.michelzarpelon.spring_boot_mongoDB.domain.User;
import com.michelzarpelon.spring_boot_mongoDB.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository objRepository;
	
	public List<User> findAll(){
		return objRepository.findAll();
	}
	
}
