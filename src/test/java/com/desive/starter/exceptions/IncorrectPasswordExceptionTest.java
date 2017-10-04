package com.desive.starter.exceptions;

import org.junit.Test;

/*
 Created by Jack DeSive on 10/3/2017 at 4:57 PM
*/
public class IncorrectPasswordExceptionTest {

    @Test(expected = IncorrectPasswordException.class)
    public void throwIncorrectPasswordException(){
        throw new IncorrectPasswordException("Password");
    }

}
