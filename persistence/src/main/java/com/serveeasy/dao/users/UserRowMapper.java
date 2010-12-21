package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
class UserRowMapper implements RowMapper<User> {


    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        UserResultSetExtractor ext  = new UserResultSetExtractor();
        return ext.extractData(resultSet);
    }
}
