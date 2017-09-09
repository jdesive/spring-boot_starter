package com.desive.starter.repositories;

import java.util.Optional;

import com.desive.starter.entities.User;
import com.desive.starter.support.jpa.CustomJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CustomJpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
