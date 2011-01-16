package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Executor;
import com.serveeasy.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository(value = UsersDao.SPRING_BEAN_NAME)
class UsersDaoImpl extends Executor<User> implements UsersDao {

    @Autowired
    public UsersDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public void addUser(User user) {
        final InsertUser insertCommand = new InsertUser(user);
        executeUpdate(insertCommand);
    }

    public User findUser(long id) {
        final FindUser query = new FindUser(id);
        return executeQuery(query).get(0);
    }

    public List<User> getUsers() {
        FindAllUsers command = new FindAllUsers();
        return executeQuery(command);
    }

    public List<User> getUsers(boolean active, boolean privilege) {
        FindActivePrivilegedUsers comm = new FindActivePrivilegedUsers(active, privilege);
        return executeQuery(comm);
    }

    public List<User> getActiveOrInactiveUsers(boolean active) {
        FindActiveUsers command = new FindActiveUsers(active);
        return executeQuery(command);
    }

    public List<User> getPrivilegedOrUnprivilegedUsers(boolean privilege) {
        FindPrivilegedUsers comm = new FindPrivilegedUsers(privilege);
        return executeQuery(comm);
    }

    public void deleteUser(long id) {
        DeleteUser delete = new DeleteUser(id);
        executeUpdate(delete);
    }

    public void updateUser(User user) {
        UpdateUser update = new UpdateUser(user);
        executeUpdate(update);
    }
}