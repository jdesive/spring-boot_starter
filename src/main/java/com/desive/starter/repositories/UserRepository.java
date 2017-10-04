package com.desive.starter.repositories;

import com.desive.starter.entities.User;
import com.desive.starter.repositories.interfaces.IUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*
 The users repository JPA query methods

 Created by Jack DeSive on 10/3/2017 at 3:17 AM
*/
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>, IUserRepository{

    User findByUsername(String username);

}
