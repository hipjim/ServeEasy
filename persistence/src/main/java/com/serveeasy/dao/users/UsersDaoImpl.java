package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

//todo : get user by id, by username, by fullname, get active users, get inactive users, get admin
//todo: get users with privileges, get active users with privileges, get users,
//todo: delete user by if, username, fullname
//todo: activate/deactivate user, grant/revoke privileges
//todo: 

@Repository(value = UsersDao.SPRING_BEAN_NAME)
class UsersDaoImpl implements UsersDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addUser(User user) {
        String query = "INSERT INTO `serveeasy`.`users` " +
                " SET `username` = '"+user.getUsername()+"' " +
                " ";
        jdbcTemplate.execute(query);
    }
}