package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Query;
import com.serveeasy.model.users.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * User: cristian.popovici
 */
final class UsernameQuery extends Query<User> {

    private final String QUERY = "SELECT * FROM `serveeasy`.`users` WHERE `username` = ?";

    private final String userName;

    UsernameQuery(String userName) {
        this.userName = userName;
    }

    @Override
    public RowMapper<User> getRowMapper() {
        return new UserRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ps.setString(1, userName);

        return ps;
    }
}
