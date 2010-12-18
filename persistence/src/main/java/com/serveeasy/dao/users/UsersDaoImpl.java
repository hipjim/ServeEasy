package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import com.serveeasy.model.users.UserType;
import com.serveeasy.model.users.UsersFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository(value = UsersDao.SPRING_BEAN_NAME)
class UsersDaoImpl implements UsersDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addUser(User user) {
        String query = "INSERT INTO `serveeasy`.`users` " +
                " SET `username` = '" + user.getUsername() + "' " +
                " ";
        jdbcTemplate.execute(query);
    }

    public List<User> getUser(int id) {
        String query = "SELECT * FROM `serveeasy`.`users` " +
                " WHERE `id` = " + id + "";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    public List<User> getUser(String username) {
        String query = "SELECT * FROM `serveeasy`.`users` " +
                " WHERE `username` = '" + username + "'";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    public List<User> getUsers() {
        String query = "SELECT * FROM `serveeasy`.`users` ";
        return jdbcTemplate.query(query, new UserRowMapper());
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

    public int activateOrDeactivateUser(int id, boolean activate) {
        String query = "UPDATE `serveeasy`.`users` " +
                " SET `active` = "+activate+" " +
                " WHERE `id` = " + id + "";
        return jdbcTemplate.update(query);
    }

    public int grantOrRevokePrivileges(int id, boolean privileges) {
       String query = "UPDATE `serveeasy`.`users` " +
                " SET `is_with_privileges` = "+privileges+" " +
                " WHERE `id` = " + id + "";
        return jdbcTemplate.update(query);
    }

    public int updateUser(int id, User user) {
       String query = "UPDATE `serveeasy`.`users` " +
                " SET `username` = '"+user.getUsername()+"', " +
               " `password` = '"+user.getPassword()+"', " +
               " `fullname` = '"+user.getFullname()+"', " +
               " `is_admin` = "+user.isAdmin()+", " +
               " `active` = "+user.isActive()+", " +
               " `is_with_privileges` = "+user.isWithPrivileges()+" " +
                " WHERE `id` = " + id + "";
        return jdbcTemplate.update(query);
    }
}