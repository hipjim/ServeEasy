package com.serveeasy.dao.users;

import com.serveeasy.dao.DaoRepository;
import com.serveeasy.model.users.User;
import com.serveeasy.model.users.UserType;
import com.serveeasy.model.users.UsersFactory;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsersDaoImplTest extends TestCase {

    private UsersDao dao;

    @Before
    public void setUp() {
       ApplicationContext ctx = new ClassPathXmlApplicationContext("com/serveeasy/context/applicationContext.xml");


        DaoRepository repository = (DaoRepository) ctx.getBean("daoRepository");
        dao = repository.getUsersDao();
    }

    @Test
    public void testAddUser() throws Exception {
        UsersFactory uf = new UsersFactory();
        User usr = uf.createUser(UserType.EMPLOYEE);
        usr.setUsername("test_username");
        dao.addUser(usr);
    }

    @Test
    public void testGetUser() {
        System.out.println(dao.getUser(5));
        System.out.println(dao.getUser(8));
//        assertEquals(dao.getUser(6).size(), 1);
//        assertEquals(3, dao.getUsers().size());
//        assertEquals(dao.getActiveOrInactiveUsers(true).size(), 1);
//        assertEquals(dao.getActiveOrInactiveUsers(false).size(), 2);
//        assertEquals(dao.getPrivilegedOrUnprivilegedUsers(true).size(), 2);
//        assertEquals(dao.getPrivilegedOrUnprivilegedUsers(false).size(), 1);
//        assertEquals(dao.getUser("test").size(), 0);
//        assertEquals(dao.getUser("test_username").size(), 1);
//        assertEquals(dao.getUsers(true,true).size(), 1);
//        assertEquals(dao.getUsers(true,false).size(), 0);
//        assertEquals(dao.getUsers(false,true).size(), 1);
//        assertEquals(dao.getUsers(false,false).size(), 1);
    }

    @Test
    public void testDeleteUser() {
//        dao.deleteUser(6);
    }

    @Test
    public void testUpdate() {
        UsersFactory uf = new UsersFactory();
        User usr = uf.createUser(UserType.EMPLOYEE);
        usr.setUsername("test_username");
        usr.setFullname("tralala");
        usr.setActive(true);
        usr.setPassword("testing");
        usr.setWithPrivileges(true);

        dao.updateUser(8, usr);
    }

}
