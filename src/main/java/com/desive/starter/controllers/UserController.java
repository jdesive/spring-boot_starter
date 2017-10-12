/*
 * Copyright (C) 2017  Jack DeSive
 *
 * This file is part of Spring Boot Starter.
 *
 * Spring Boot Starter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.desive.starter.controllers;

import com.desive.starter.entities.User;
import com.desive.starter.entities.UserSignin;
import com.desive.starter.exceptions.IncorrectPasswordException;
import com.desive.starter.exceptions.UserNotFoundException;
import com.desive.starter.repositories.UserRepository;
import com.desive.starter.repositories.criteria.UserSearchCriteria;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

	@Autowired private UserRepository userRepository;

    @ApiOperation(tags = {"Users"}, value = "Search for Users", nickname = "Search", produces = "applications/json")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Page<User> findAllWithCriteria(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
										  @RequestParam(name = "size", required = false, defaultValue = "30") int size,
										  @RequestParam(name = "id", required = false) Integer userid,
										  @RequestParam(name = "username", required = false) String username,
										  @RequestParam(name = "enabled", required = false) Boolean enabled) {
        log.debug("Building user search criteria...");
        UserSearchCriteria criteria = new UserSearchCriteria(userid, username, enabled);
        log.debug("Searching users db with {}...", criteria.toString());
		return userRepository.findByCriteria(criteria, new PageRequest(page, size));
	}

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(tags = {"Users"}, value = "Sign Up to get credentials", nickname = "Sign Up", produces = "applications/json")
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user){
        log.debug("Saving {} to users db...", user.toString());
	    return userRepository.save(user);
    }

    @ApiOperation(tags = {"Users"}, value = "Check Sign In credentials", nickname = "Sign Id", produces = "applications/json")
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public Boolean userSignin(@RequestBody UserSignin userSignin){

        log.debug("Searching for user with username \'{}\' in users db...", userSignin.getUsername());
        User user = userRepository.findByUsername(userSignin.getUsername());
        if(user == null)
            throw new UserNotFoundException(userSignin.getUsername());

        if(!user.getPassword().equals(userSignin.getPassword()))
            throw new IncorrectPasswordException(userSignin.getUsername());
        log.debug("Sign in successful for user \'{}\'...", userSignin.getUsername());
        return true;
    }

}
