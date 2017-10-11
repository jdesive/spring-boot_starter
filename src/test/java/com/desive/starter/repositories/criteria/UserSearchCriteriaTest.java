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

package com.desive.starter.repositories.criteria;

import org.junit.Before;
import org.junit.Test;

import static com.desive.starter.repositories.criteria.UserSearchCriteria.withId;
import static com.desive.starter.repositories.criteria.UserSearchCriteria.withIsEnabled;
import static com.desive.starter.repositories.criteria.UserSearchCriteria.withUsername;
import static org.junit.Assert.*;

/*
 Created by Jack DeSive on 10/3/2017 at 5:02 PM
*/
public class UserSearchCriteriaTest {

    UserSearchCriteria userSearchCriteria;
    Integer id = 1;
    String username = "Username";
    Boolean enabled = false;

    @Before
    public void setup(){
        userSearchCriteria = new UserSearchCriteria(null, null, null);
    }

    @Test
    public void testFields() {
        assertNotNull(userSearchCriteria.toString());
        assertTrue(userSearchCriteria.isEmpty());

        userSearchCriteria.setId(id);
        userSearchCriteria.setUsername(username);
        userSearchCriteria.setEnabled(enabled);

        assertNotNull(userSearchCriteria.toString());
        assertFalse(userSearchCriteria.isEmpty());

        assertEquals(userSearchCriteria.getId(), id);
        assertEquals(userSearchCriteria.getUsername(), username);
        assertEquals(userSearchCriteria.getEnabled(), enabled);
    }

    @Test
    public void testSpecifications() {
        assertNotNull(withId(id));
        assertNotNull(withUsername(username));
        assertNotNull(withIsEnabled(enabled));
        assertNull(withIsEnabled(null));
        assertNull(withUsername(null));
        assertNull(withId(null));
    }



}
