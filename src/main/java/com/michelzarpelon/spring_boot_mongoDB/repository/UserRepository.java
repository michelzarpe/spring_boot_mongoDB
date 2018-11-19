package com.michelzarpelon.spring_boot_mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.michelzarpelon.spring_boot_mongoDB.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
