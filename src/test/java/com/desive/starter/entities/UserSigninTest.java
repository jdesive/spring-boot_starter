package com.desive.starter.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 Created by Jack DeSive on 10/3/2017 at 4:49 PM
*/
public class UserSigninTest {

    UserSignin userSignin;
    String username = "username", password = "password";

    @Before
    public void setup() {
        userSignin = new UserSignin();
        userSignin.setUsername(username);
        userSignin.setPassword(password);
    }

    @Test
    public void testFields() {
        assertEquals(userSignin.getUsername(), username);
        assertEquals(userSignin.getPassword(), password);
    }

}
