package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UsersDao {

    public static final String SPRING_BEAN_NAME = "usersDao";

    public abstract void addUser(User user);
}
