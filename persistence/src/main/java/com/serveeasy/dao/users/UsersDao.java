package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: eu
 * Date: Dec 11, 2010
 * Time: 2:58:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public interface UsersDao {

    public static final String SPRING_BEAN_NAME = "usersDao";

    public abstract void addUser(User user);
}
