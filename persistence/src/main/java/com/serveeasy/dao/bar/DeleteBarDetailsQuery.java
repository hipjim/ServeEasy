package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *  todo: redenimit in DeleteBarDetails
 */
class DeleteBarDetailsQuery extends Update {

    private static final String query = "DELETE FROM `serveeasy`.`bar_details` WHERE `id` = ?";

    private final int id;

    DeleteBarDetailsQuery(int id) {
        this.id = id;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        return ps;
    }
}
