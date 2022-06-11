package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dao.UserDAO;
import com.example.app.entity.UserEntity;
import com.example.app.response.CommonResponse;
import com.example.app.utils.CustomMessage;
import com.example.app.utils.CustomStatus;
import com.example.app.utils.IdGenerator;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private IdGenerator idGenerator;

	public CommonResponse saveUser(UserEntity user) {
		CommonResponse response = new CommonResponse();
		user.setStatus(true);
		user.setId(idGenerator.getGeneratedId());
		try {
			userDAO.save(user);
			response.setMessage(CustomMessage.SAVED_SUCCESSFULLY);
			response.setStatusCode(CustomStatus.CREATED);

		} catch (Exception e) {
			response.setMessage(CustomMessage.ERROR);
			response.setStatusCode(CustomStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	public List<UserEntity> getUserList() {
		return userDAO.findAll();
	}

}
