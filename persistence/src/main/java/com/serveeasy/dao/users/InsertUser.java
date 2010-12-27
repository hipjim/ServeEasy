package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Update;
import com.serveeasy.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * User: cristian.popovici
 */
final class InsertUser extends Update {

    private static final String query = "INSERT INTO `serveeasy`.`users` SET `username` = ?";

    private final User user;

    InsertUser(User user) {
        this.user = user;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getUsername());

        return ps;
    }
}
