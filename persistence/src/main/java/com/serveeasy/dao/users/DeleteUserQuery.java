package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
final class DeleteUserQuery extends Update {

    private static final String query = "DELETE FROM `serveeasy`.`users` WHERE `id` = ?";

    private final long id;

    DeleteUserQuery(long id) {
        this.id = id;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);

        return ps;
    }
}
