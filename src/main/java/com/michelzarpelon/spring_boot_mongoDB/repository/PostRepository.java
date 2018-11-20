package com.michelzarpelon.spring_boot_mongoDB.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.michelzarpelon.spring_boot_mongoDB.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{'title':{$regex: ?0, $options: 'i'}}")
	List<Post> findByTitle(String text);
	
	
	
	@Query(" { $and: [ {date: {$gte: ?1} },{date: {$lte: ?2} },{ $or: [ {'body':{$regex: ?0, $options: 'i'}}, {'title':{$regex: ?0, $options: 'i'}}, {'comentario.text':{$regex: ?0, $options: 'i'}} ] }] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
