package com.example.app.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.app.entity.UserEntity;

public interface UserDAO extends MongoRepository<UserEntity, String>{
	
	  List<UserEntity> findByRole(String role);

}
