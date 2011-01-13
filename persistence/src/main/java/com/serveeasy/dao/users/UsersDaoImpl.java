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

    public User getUser(long id) {
        final UserQuery query = new UserQuery(id);
        return executeQuery(query).get(0);
    }

    public User getUser(String username) {
        final UsernameQuery command = new UsernameQuery(username);
        return executeQuery(command).get(0);
    }

    public List<User> getUsers() {
        FindAllUsersQuery command = new FindAllUsersQuery();
        return executeQuery(command);
    }

    public List<User> getUsers(boolean active, boolean privilege) {
        FindActivePrivilegedUsersQuery comm = new FindActivePrivilegedUsersQuery(active, privilege);
        return executeQuery(comm);
    }

    public List<User> getActiveOrInactiveUsers(boolean active) {
        FindActiveUsersQuery command = new FindActiveUsersQuery(active);
        return executeQuery(command);
    }

    public List<User> getPrivilegedOrUnprivilegedUsers(boolean privilege) {
        FindPrivilegedUsersQuery comm = new FindPrivilegedUsersQuery(privilege);
        return executeQuery(comm);
    }

    public void deleteUser(long id) {
        DeleteUserQuery delete = new DeleteUserQuery(id);
        executeUpdate(delete);
    }

    public void deleteUser(String username) {
        DeleteUsernameQuery delete = new DeleteUsernameQuery(username);
        executeUpdate(delete);
    }

    public void modifyUserActive(int id, boolean activate) {
        UpdateActiveQuery update = new UpdateActiveQuery(id, activate);
        executeUpdate(update);
    }

    public void modifyUserPrivileges(int id, boolean privileges) {
        UpdatePrivilegesQuery update = new UpdatePrivilegesQuery(id, privileges);
        executeUpdate(update);
    }

    public void updateUser(User user) {
        UpdateUserQuery update = new UpdateUserQuery(user);
        executeUpdate(update);
    }
}