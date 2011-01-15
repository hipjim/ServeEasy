package com.serveeasy.dao.table;

import com.serveeasy.dao.api.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * User: cristian.popovici
 */
final class DeleteTable extends Update {

    private final String DELETE = "DELETE FROM tables WHERE id = ?";

    private final long id;

    DeleteTable(long id) {
        this.id = id;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE);
        ps.setLong(1, id);

        return ps;
    }
}
