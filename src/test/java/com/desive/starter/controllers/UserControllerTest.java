package com.desive.starter.controllers;

import com.desive.starter.entities.User;
import com.desive.starter.entities.UserSignin;
import com.desive.starter.repositories.UserRepository;
import com.desive.starter.repositories.criteria.UserSearchCriteria;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/*
 Created by Jack DeSive on 10/3/2017 at 5:11 PM
*/
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = UserController.class)
@PropertySource("classpath:application-test.properties")
public class UserControllerTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserController userController;

    ObjectMapper mapper = new ObjectMapper();
    User user;
    UserSignin userSignin;
    Integer id = 1;
    String username = "username", password = "password";
    Boolean enabled = false;
    Date creatationDate = new Date(System.currentTimeMillis()-5000), modificationDate = new Date(System.currentTimeMillis());
    MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = standaloneSetup(userController).build();
        user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEnabled(enabled);
        user.setCreationTime(creatationDate);
        user.setModificationTime(modificationDate);
        userRepository.save(user);
        userSignin = new UserSignin(user.getUsername(), user.getPassword());
    }

    @After
    public void teardown() {
        userRepository.delete(id);
    }

    @Test
    public void searchUsersById() throws Exception{
        this.testSearchCriteria("id", String.valueOf(id));
    }

    @Test
    public void searchUsersByUsername() throws Exception{
        this.testSearchCriteria("username", username);
    }

    @Test
    public void searchUsersByIsEnabled() throws Exception{
        this.testSearchCriteria("enabled", String.valueOf(enabled));
    }

    private void testSearchCriteria(String param, String value) throws Exception {
        PageImpl<User> page = new PageImpl<>(Lists.newArrayList(user), new PageRequest(0, 2), 2L);
        when(userRepository.findByCriteria(any(UserSearchCriteria.class), any(Pageable.class))).thenReturn(page);
        mockMvc.perform(get("/users")
                .param(param, value))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(page)));
    }

    @Test
    public void signup() throws Exception {

        when(userRepository.save(any(User.class))).thenReturn(user);
        mockMvc.perform(post("/signup")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(mapper.writeValueAsBytes(user)))
                .andExpect(status().isCreated())
                .andExpect(content().string(mapper.writeValueAsString(user)));
    }

    @Test
    public void signin() throws Exception {

        when(userRepository.findByUsername(any(String.class))).thenReturn(user);
        mockMvc.perform(post("/signin")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(userSignin)))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void signinUserNotFound() throws Exception {

        when(userRepository.findByUsername(any(String.class))).thenReturn(null);
        mockMvc.perform(post("/signin")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(userSignin)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void signinIncorrectPassword() throws Exception {

        when(userRepository.findByUsername(any(String.class))).thenReturn(user);
        mockMvc.perform(post("/signin")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(new UserSignin(username, ""))))
                .andExpect(status().isBadRequest());
    }

}
