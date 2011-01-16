package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
class DeleteBarDetails extends Update {

    private static final String query = "DELETE FROM `serveeasy`.`bar_details` WHERE `id` = ?";

    private final long id;

    DeleteBarDetails(long id) {
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
