package com.serveeasy.dao.users;

import com.serveeasy.dao.AbstractSpringTestCase;
import com.serveeasy.model.users.User;
import com.serveeasy.model.users.UserType;
import com.serveeasy.model.users.UsersFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersDaoImplTest extends AbstractSpringTestCase {

    @Autowired
    private UsersDao dao;

    @Test
    public void testAddUser() throws Exception {
        User usr = UsersFactory.createUser(UserType.EMPLOYEE);
        usr.setUsername("test_username_ps");
        usr.setBarId(3);
        usr.setActive(true);
        usr.setFullname("Test User");
        usr.setPassword("pass");
        usr.setWithPrivileges(false);
        dao.addUser(usr);
    }

    @Test
    public void testGetUser() {
        System.out.println(dao.findUser(5));
        System.out.println(dao.findUser(8));
//        assertEquals(dao.findUser(6).size(), 1);
//        assertEquals(3, dao.getUsers().size());
//        assertEquals(dao.getActiveOrInactiveUsers(true).size(), 1);
//        assertEquals(dao.getActiveOrInactiveUsers(false).size(), 2);
//        assertEquals(dao.getPrivilegedOrUnprivilegedUsers(true).size(), 2);
//        assertEquals(dao.getPrivilegedOrUnprivilegedUsers(false).size(), 1);
//        assertEquals(dao.findUser("test").size(), 0);
//        System.out.println(dao.getUser("test_username"));
//        assertEquals(dao.getUsers(true,true).size(), 1);
//        assertEquals(dao.getUsers(true,false).size(), 0);
//        assertEquals(dao.getUsers(false,true).size(), 1);
        System.out.println(dao.getUsers());

        System.out.println(dao.getActiveOrInactiveUsers(true));
        System.out.println(dao.getActiveOrInactiveUsers(false));
    }

    @Test
    public void testDeleteUser() {
//        dao.deleteUser(6);
    }

    @Test
    public void testUpdate() {
        User usr = UsersFactory.createUser(UserType.EMPLOYEE);
        usr.setUsername("test_username");
        usr.setFullname("tralala");
        usr.setActive(true);
        usr.setPassword("testing");
        usr.setWithPrivileges(true);
        usr.setId(4);

        dao.updateUser(usr);
    }

}
