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

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
 Created by Jack DeSive on 10/3/2017 at 11:07 AM
*/
public class UserTest {

    User user;
    String username = "", password = "";
    int id = 1;
    Boolean enabled = false;
    Date creationDate = new Date(System.currentTimeMillis()-5000), modificationDate = new Date(System.currentTimeMillis());

    @Before
    public void setup(){
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setId(id);
        user.setEnabled(enabled);
        user.setCreationTime(creationDate);
        user.setModificationTime(modificationDate);
    }

    @Test
    public void testFields() {
        assertEquals(user.getUsername(), username);
        assertEquals(user.getPassword(), password);
        assertEquals(String.valueOf(user.getId()), String.valueOf(id));
        assertEquals(user.getCreationTime(), creationDate);
        assertEquals(user.getModificationTime(), modificationDate);
        assertEquals(user.getEnabled(), enabled);
    }

    @Test
    public void testPreMethods() {
        user.prePersist();
        user.preUpdate();
    }

    @Test
    public void testAnnotations(){
        assertNotNull(user.toString());
        assertNotNull(user.hashCode());
        assertNotNull(user.equals(user));
    }

}
