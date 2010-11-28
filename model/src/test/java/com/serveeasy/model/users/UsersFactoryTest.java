package com.serveeasy.model.users;

import com.serveeasy.model.AbstractTestCase;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: eu
 * Date: Nov 27, 2010
 * Time: 7:36:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsersFactoryTest extends AbstractTestCase {

    @Test
    public void testFactory() {
        UsersFactory uh = new UsersFactory();
        try {
            User admin = uh.createUser(UserType.ADMIN);
            assertEquals(true, admin.isAdmin());

            User emp = uh.createUser(UserType.EMPLOYEE);
            assertEquals(false, emp.isAdmin());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

