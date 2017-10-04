package com.desive.starter.repositories.impl;

import com.desive.starter.entities.User;
import com.desive.starter.repositories.UserRepository;
import com.desive.starter.repositories.criteria.UserSearchCriteria;
import com.desive.starter.repositories.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.desive.starter.repositories.criteria.UserSearchCriteria.withId;
import static com.desive.starter.repositories.criteria.UserSearchCriteria.withIsEnabled;
import static com.desive.starter.repositories.criteria.UserSearchCriteria.withUsername;
import static org.springframework.data.jpa.domain.Specifications.where;

/*
 Custom JPA query logic

 Created by Jack DeSive on 10/3/2017 at 3:17 AM
*/
public class UserRepositoryImpl implements IUserRepository{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findByCriteria(UserSearchCriteria criteria, Pageable pageable) {
        if(criteria.isEmpty())
            return userRepository.findAll(pageable);
        return userRepository.findAll(where(withId(criteria.getId()))
        .and(withUsername(criteria.getUsername()))
        .and(withIsEnabled(criteria.getEnabled())), pageable);
    }

}
