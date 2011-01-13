package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class UpdateActiveQuery extends Update {

    private static final String query = "UPDATE `serveeasy`.`users` SET `active` = ? WHERE `id` = ?";

    private boolean active;
    private int id;

    UpdateActiveQuery(int id, boolean active) {
        this.active = active;
        this.id = id;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setBoolean(1, active);
        ps.setInt(2, id);
        return ps;
    }
}
