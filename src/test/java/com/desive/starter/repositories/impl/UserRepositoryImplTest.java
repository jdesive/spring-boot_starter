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

package com.desive.starter.repositories.impl;

import com.desive.starter.entities.User;
import com.desive.starter.repositories.UserRepository;
import com.desive.starter.repositories.criteria.UserSearchCriteria;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/*
 Created by Jack DeSive on 10/3/2017 at 6:47 PM
*/
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(UserRepository.class)
@ContextConfiguration(classes = UserRepository.class)
@PropertySource("classpath:application-test.properties")
public class UserRepositoryImplTest {

    @InjectMocks
    UserRepositoryImpl userRepositoryImpl;

    @Mock
    UserRepository userRepository;

    User user;
    Integer id = 1;
    String username = "username", password = "password";
    Boolean enabled = false;
    Date creatationDate = new Date(System.currentTimeMillis()-5000), modificationDate = new Date(System.currentTimeMillis());

    @Before
    public void setup() {
        user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEnabled(enabled);
        user.setCreationTime(creatationDate);
        user.setModificationTime(modificationDate);
        userRepository.save(user);
    }

    @After
    public void teardown() {
        userRepository.delete(id);
    }

    @Test
    public void searchCriteriaNull() throws Exception {
        PageImpl<User> page = new PageImpl<>(Lists.newArrayList(), new PageRequest(0, 2), 2L);
        when(userRepository.findAll(any(Pageable.class))).thenReturn(page);
        assertEquals(userRepositoryImpl.findByCriteria(new UserSearchCriteria(null, null, null),
                new PageRequest(0, 2)), page);
    }

    @Test
    public void searchCriteriaById() throws Exception {
        PageImpl<User> page = new PageImpl<>(Lists.newArrayList(user), new PageRequest(0, 2), 2L);
        when(userRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(page);
        assertEquals(userRepositoryImpl.findByCriteria(new UserSearchCriteria(id, null, null),
                new PageRequest(0, 2)), page);
    }

    @Test
    public void searchCriteriaByUsername() throws Exception {
        PageImpl<User> page = new PageImpl<>(Lists.newArrayList(user), new PageRequest(0, 2), 2L);
        when(userRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(page);
        assertEquals(userRepositoryImpl.findByCriteria(new UserSearchCriteria(null, username, null),
                new PageRequest(0, 2)), page);
    }

    @Test
    public void searchCriteriaByIsEnabled() throws Exception {
        PageImpl<User> page = new PageImpl<>(Lists.newArrayList(user), new PageRequest(0, 2), 2L);
        when(userRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(page);
        assertEquals(userRepositoryImpl.findByCriteria(new UserSearchCriteria(null, null, enabled),
                new PageRequest(0, 2)), page);
    }

    @Test
    public void searchCriteriaAllTogetherNow() throws Exception {
        PageImpl<User> page = new PageImpl<>(Lists.newArrayList(user), new PageRequest(0, 2), 2L);
        when(userRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(page);
        assertEquals(userRepositoryImpl.findByCriteria(new UserSearchCriteria(id, username, enabled),
                new PageRequest(0, 2)), page);
    }

}
