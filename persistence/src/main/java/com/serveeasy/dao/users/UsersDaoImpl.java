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

    public User getUser(int id) {
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
        String query = "SELECT * FROM `serveeasy`.`users` " +
                " WHERE `active` = " + active + " AND " +
                " `is_with_privileges` = " + privilege + "";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    public List<User> getActiveOrInactiveUsers(boolean active) {
        String query = "SELECT * FROM `serveeasy`.`users` " +
                "WHERE `active` = " + active + "";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    public List<User> getPrivilegedOrUnprivilegedUsers(boolean privilege) {
        String query = "SELECT * FROM `serveeasy`.`users` " +
                "WHERE `is_with_privileges` = " + privilege + "";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    public int deleteUser(int id) {
        String query = "DELETE FROM `serveeasy`.`users` " +
                "WHERE `id` = " + id + "";
        return jdbcTemplate.update(query);
    }

    public int deleteUser(String username) {
        String query = "DELETE FROM `serveeasy`.`users` " +
                "WHERE `username` = '" + username + "'";
        return jdbcTemplate.update(query);
    }

    public int modifyUserActive(int id, boolean activate) {
        String query = "UPDATE `serveeasy`.`users` " +
                " SET `active` = " + activate + " " +
                " WHERE `id` = " + id + "";
        return jdbcTemplate.update(query);
    }

    public int modifyUserPrivileges(int id, boolean privileges) {
        String query = "UPDATE `serveeasy`.`users` " +
                " SET `is_with_privileges` = " + privileges + " " +
                " WHERE `id` = " + id + "";
        return jdbcTemplate.update(query);
    }

    public int updateUser(int id, User user) {
        String query = "UPDATE `serveeasy`.`users` " +
                " SET `username` = '" + user.getUsername() + "', " +
                " `password` = '" + user.getPassword() + "', " +
                " `fullname` = '" + user.getFullname() + "', " +
                " `is_admin` = " + user.isAdmin() + ", " +
                " `active` = " + user.isActive() + ", " +
                " `is_with_privileges` = " + user.isWithPrivileges() + " " +
                " WHERE `id` = " + id + "";
        return jdbcTemplate.update(query);
    }
}