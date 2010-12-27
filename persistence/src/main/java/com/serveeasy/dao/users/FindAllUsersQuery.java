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
final class FindAllUsersQuery extends Query<User> {

    private final static String query = "SELECT * FROM `serveeasy`.`users` ";


    @Override
    public RowMapper<User> getRowMapper() {
        return new UserRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement(query);
    }
}
