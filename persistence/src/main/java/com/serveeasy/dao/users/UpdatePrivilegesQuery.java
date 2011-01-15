package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class UpdatePrivilegesQuery extends Update {

    private static final String query = "UPDATE `serveeasy`.`users` SET `is_with_privileges` = ? WHERE `id` = ?";

    private boolean is_with_privileges;
    private long id;

    UpdatePrivilegesQuery(long id, boolean is_with_privileges) {
        this.is_with_privileges = is_with_privileges;
        this.id = id;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setBoolean(1, is_with_privileges);
        ps.setLong(2, id);
        return ps;
    }
}

