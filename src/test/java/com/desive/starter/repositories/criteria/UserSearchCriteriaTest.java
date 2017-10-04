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
