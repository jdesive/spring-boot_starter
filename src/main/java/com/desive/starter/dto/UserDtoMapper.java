package com.dlizarra.starter.user;

import com.desive.starter.dto.UserDto;
import com.desive.starter.entities.User;
import ma.glasnost.orika.CustomMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper extends CustomMapper<User, UserDto> {
	// @Override
	// public void mapAtoB(final User user, final UserDto userDto, final MappingContext context) {
	// userDto.getProjects().forEach(p -> {
	// if (p.getCreator() != null) {
	// p.getCreator().setProjects(new ArrayList<ProjectDto>());
	// }
	// p.setMembers(new ArrayList<UserDto>());
	// });

	// userDto.getProjects().forEach(p -> {
	// if (p.getCreator() != null) {
	// p.getCreator().setProjects(new ArrayList<ProjectDto>());
	// }
	// p.setMembers(new ArrayList<UserDto>());
	// });
	// }

}
