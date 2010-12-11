package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository(value = UsersDao.SPRING_BEAN_NAME)
class UsersDaoImpl implements UsersDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addUser(User user) {
        String query = "INSERT INTO `serveeasy`.`bar_users` " +
                " SET `username` = '"+user.getUsername()+"'";
        jdbcTemplate.execute(query);
    }
}
