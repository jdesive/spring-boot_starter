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
