package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UsersDao {

    public static final String SPRING_BEAN_NAME = "usersDao";

    void addUser(User user);

    User getUser(long id);

    List<User> getUsers();

    User getUser(String username);

    List<User> getUsers(boolean active, boolean privilege);

    List<User> getActiveOrInactiveUsers(boolean active);

    List<User> getPrivilegedOrUnprivilegedUsers(boolean privilege);

    void deleteUser(int id);

    void deleteUser(String username);

    void modifyUserActive(long id, boolean activate);

    void modifyUserPrivileges(long id, boolean privileges);

    void updateUser(User user);
}
