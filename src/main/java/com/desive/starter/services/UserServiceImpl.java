package com.desive.starter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.desive.starter.dto.UserDto;
import com.desive.starter.entities.Role;
import com.desive.starter.entities.RoleName;
import com.desive.starter.entities.User;
import com.desive.starter.exceptions.UserNotFoundException;
import com.desive.starter.repositories.UserRepository;
import com.desive.starter.support.orika.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrikaBeanMapper mapper;

	@Transactional
	@Override
	public void createUser(final UserDto userDto, final RoleName roleName) {
		final User user = mapper.map(userDto, User.class);
		final Role role = new Role();
		role.setRolename(roleName);
		role.setUser(user);
		user.getRoles().add(role);
		user.setEnabled(true);

		userRepository.save(user);
	}

	@Transactional(readOnly = true)
	@Override
	public List<UserDto> getUsers() {
		final List<User> users = userRepository.findAll(new Sort("id"));
		final List<UserDto> usersDto = new ArrayList<UserDto>();
		users.forEach(x -> usersDto.add(mapper.map(x, UserDto.class)));

		return usersDto;
	}

	@Transactional(readOnly = true)
	@Override
	public UserDto getUser(final Integer id) {
		return mapper.map(find(id), UserDto.class);
	}

	@Transactional
	@Override
	public void updateUser(final UserDto user) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void deleteUser(final Integer id) {
		userRepository.delete(id);
	}

	@Transactional(readOnly = true)
	private User find(final Integer id) {
		final Optional<User> userOpt = userRepository.findOne(id);
		return userOpt.orElseThrow(() -> new UserNotFoundException(id));
	}

}
