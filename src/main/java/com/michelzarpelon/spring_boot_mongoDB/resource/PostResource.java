package com.michelzarpelon.spring_boot_mongoDB.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michelzarpelon.spring_boot_mongoDB.domain.Post;
import com.michelzarpelon.spring_boot_mongoDB.resource.util.URL;
import com.michelzarpelon.spring_boot_mongoDB.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

		List<Post> obj = service.findByTitle(URL.decodeParam(text));

		return ResponseEntity.ok().body(obj);
	}

}
