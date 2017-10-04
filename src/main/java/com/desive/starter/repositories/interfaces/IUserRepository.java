package com.desive.starter.repositories.interfaces;

import com.desive.starter.entities.User;
import com.desive.starter.repositories.criteria.UserSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/*
 Custom JPA query methods

 Created by Jack DeSive on 10/3/2017 at 3:12 AM
*/
public interface IUserRepository {

    Page<User> findByCriteria(UserSearchCriteria criteria, Pageable pageable);

}
