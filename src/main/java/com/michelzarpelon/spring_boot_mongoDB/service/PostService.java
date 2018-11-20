package com.michelzarpelon.spring_boot_mongoDB.service;

import java.util.Date;
import java.util.List;
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

	public List<Post> findByTitle(String text){
		return objRepository.findByTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		return objRepository.fullSearch(text, minDate, maxDate);
	}
		
}
