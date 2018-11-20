package com.michelzarpelon.spring_boot_mongoDB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.michelzarpelon.spring_boot_mongoDB.domain.Post;
import com.michelzarpelon.spring_boot_mongoDB.repository.PostRepository;
import com.michelzarpelon.spring_boot_mongoDB.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository objRepository;

	public Post findById(String id) {
		Optional<Post> obj = objRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}


}
