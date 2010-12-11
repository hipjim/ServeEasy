package com.serveeasy.dao.users;

import com.serveeasy.dao.DaoRepository;
import com.serveeasy.dao.table.TableDao;
import com.serveeasy.model.users.User;
import com.serveeasy.model.users.UserType;
import com.serveeasy.model.users.UsersFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: eu
 * Date: Dec 11, 2010
 * Time: 3:34:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsersDaoImplTest {

    @Test
    public void testAddUser() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/serveeasy/context/applicationContext.xml");


        DaoRepository repository = (DaoRepository) ctx.getBean("daoRepository");
        UsersDao dao = repository.getUsersDao();

        UsersFactory uf = new UsersFactory();
        User usr = uf.createUser(UserType.EMPLOYEE);
        usr.setUsername("test_username");
        

        dao.addUser(usr);
    }

}
