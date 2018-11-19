package com.michelzarpelon.spring_boot_mongoDB.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.michelzarpelon.spring_boot_mongoDB.DTO.UserDTO;
import com.michelzarpelon.spring_boot_mongoDB.domain.User;
import com.michelzarpelon.spring_boot_mongoDB.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	return ResponseEntity.ok().body(listDTO);
	}
		
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = service.findById(id);
		UserDTO obj = new UserDTO(user);
	return ResponseEntity.ok().body(obj);
	}
}
