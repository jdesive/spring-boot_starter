package com.desive.starter.exceptions;

import org.junit.Test;

/*
 Created by Jack DeSive on 10/3/2017 at 4:57 PM
*/
public class UserNotFoundExceptionTest {

    @Test(expected = UserNotFoundException.class)
    public void throwUserNotFoundExceptionByUsername(){
        throw new UserNotFoundException("Username");
    }

    @Test(expected = UserNotFoundException.class)
    public void throwUserNotFoundExceptionById(){
        throw new UserNotFoundException(1);
    }


}
