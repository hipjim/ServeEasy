package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class DeleteUsernameQuery extends Update {

    private static final String query = "DELETE FROM `serveeasy`.`users` WHERE `username` = ?";

    private final String username;

    DeleteUsernameQuery(String username) {
        this.username = username;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username) ;

        return ps;
    }
}
