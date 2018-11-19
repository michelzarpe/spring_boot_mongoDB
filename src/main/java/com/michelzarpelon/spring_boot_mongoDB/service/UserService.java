package com.michelzarpelon.spring_boot_mongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.michelzarpelon.spring_boot_mongoDB.domain.User;
import com.michelzarpelon.spring_boot_mongoDB.repository.UserRepository;
import com.michelzarpelon.spring_boot_mongoDB.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository objRepository;

	public List<User> findAll() {
		return objRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = objRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
