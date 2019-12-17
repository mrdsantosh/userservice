package com.examples.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examples.projects.dao.UserServiceDAO;
import com.examples.projects.model.Users;

@RestController
public class UserServiceRestController {
	@Autowired
	UserServiceDAO userServiceDAO;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Users> getUsersList() {
		return userServiceDAO.getUsersList();
	}
}