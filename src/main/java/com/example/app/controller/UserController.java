package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.UserEntity;
import com.example.app.response.CommonResponse;
import com.example.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<com.example.app.response.CommonResponse> saveUser(@RequestBody UserEntity user) {
		CommonResponse response = userService.saveUser(user);
		return new ResponseEntity<CommonResponse>(response, HttpStatus.CREATED);
	}

	@GetMapping("/userList")
	public ResponseEntity<List<UserEntity>> getUserList() {
		List<UserEntity> response = userService.getUserList();
		return new ResponseEntity<List<UserEntity>>(response, HttpStatus.OK);

	}

}
