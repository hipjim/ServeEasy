package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface UsersDao {

    public static final String SPRING_BEAN_NAME = "usersDao";

    public abstract void addUser(User user);

    public abstract List<User> getUser(int id);

    public abstract List<User> getUsers();

    public abstract List<User> getUser(String username);

    public abstract List<User> getUsers(boolean active, boolean privilege);

    public abstract List<User> getActiveOrInactiveUsers(boolean active);

    public abstract List<User> getPrivilegedOrUnprivilegedUsers(boolean privilege);

    public abstract int deleteUser(int id);

    public abstract int deleteUser(String username);

    public abstract int activateOrDeactivateUser(int id, boolean activate);

    public abstract int grantOrRevokePrivileges(int id, boolean privileges);

    public abstract int updateUser(int id, User user);
}
