package com.michelzarpelon.spring_boot_mongoDB.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.michelzarpelon.spring_boot_mongoDB.DTO.AuthorDTO;
import com.michelzarpelon.spring_boot_mongoDB.domain.Post;
import com.michelzarpelon.spring_boot_mongoDB.domain.User;
import com.michelzarpelon.spring_boot_mongoDB.repository.PostRepository;
import com.michelzarpelon.spring_boot_mongoDB.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"),"Partiu Viagem", "vou viajar para joaçaba",new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("23/03/2018"),"Bom dia", "Acordei de Boa hoje",new AuthorDTO(maria));
		
		
		postRepository.saveAll(Arrays.asList(p1,p2));
	
	}
}
