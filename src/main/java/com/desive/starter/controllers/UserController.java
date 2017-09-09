package com.desive.starter.controllers;

import java.util.List;

import com.desive.starter.dto.UserDto;
import com.desive.starter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDto> findAll() {
		return userService.getUsers();
	}

}
