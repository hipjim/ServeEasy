package com.serveeasy.model.users;

import com.serveeasy.model.AbstractTestCase;
import org.junit.Test;

/**
 * User: eu
 * Date: Nov 27, 2010
 */
public class UsersFactoryTest extends AbstractTestCase {

    @Test
    public void testFactory() throws Exception {

        User admin = UsersFactory.createUser(UserType.ADMIN);
        assertEquals(true, admin.isAdmin());

        User emp = UsersFactory.createUser(UserType.EMPLOYEE);
        assertEquals(false, emp.isAdmin());
    }
}

