package com.desive.starter.services;

import java.util.List;

import com.desive.starter.dto.UserDto;
import com.desive.starter.entities.RoleName;

public interface UserService {

	void createUser(UserDto user, RoleName roleName);

	void updateUser(UserDto user);

	void deleteUser(Integer id);

	UserDto getUser(Integer id);

	List<UserDto> getUsers();

}
