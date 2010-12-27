package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UsersDao {

    public static final String SPRING_BEAN_NAME = "usersDao";

    void addUser(User user);

    User getUser(int id);

    List<User> getUsers();

    User getUser(String username);

    List<User> getUsers(boolean active, boolean privilege);

    List<User> getActiveOrInactiveUsers(boolean active);

    List<User> getPrivilegedOrUnprivilegedUsers(boolean privilege);

    int deleteUser(int id);

    int deleteUser(String username);

    int modifyUserActive(int id, boolean activate);

    int modifyUserPrivileges(int id, boolean privileges);

    int updateUser(int id, User user);
}
