package com.desive.starter.controllers;

import com.desive.starter.entities.User;
import com.desive.starter.entities.UserSignin;
import com.desive.starter.exceptions.IncorrectPasswordException;
import com.desive.starter.exceptions.UserNotFoundException;
import com.desive.starter.repositories.UserRepository;
import com.desive.starter.repositories.criteria.UserSearchCriteria;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
		return userRepository.findByCriteria(new UserSearchCriteria(userid, username, enabled), new PageRequest(page, size));
	}

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(tags = {"Users"}, value = "Sign Up to get credentials", nickname = "Sign Up", produces = "applications/json")
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user){
	    return userRepository.save(user);
    }

    @ApiOperation(tags = {"Users"}, value = "Check Sign In credentials", nickname = "Sign Id", produces = "applications/json")
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public Boolean userSignin(@RequestBody UserSignin userSignin){

        User user = userRepository.findByUsername(userSignin.getUsername());
        if(user == null)
            throw new UserNotFoundException(userSignin.getUsername());

        if(!user.getPassword().equals(userSignin.getPassword()))
            throw new IncorrectPasswordException(userSignin.getUsername());

        return true;
    }

}
