package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UsersDao {

    public static final String SPRING_BEAN_NAME = "usersDao";

    void addUser(User user);

    User findUser(long id);

    List<User> getUsers();

    List<User> getUsers(boolean active, boolean privilege);

    List<User> getActiveOrInactiveUsers(boolean active);

    List<User> getPrivilegedOrUnprivilegedUsers(boolean privilege);

    void deleteUser(long id);

    void updateUser(User user);
}
