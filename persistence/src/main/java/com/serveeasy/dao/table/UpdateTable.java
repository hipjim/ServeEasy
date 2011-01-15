package com.serveeasy.dao.table;

import com.serveeasy.dao.api.Update;
import com.serveeasy.model.bar.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * User: cristian.popovici
 */
final class UpdateTable extends Update {

    private static final String UPDATE = "UPDATE tables SET capacity = ?, status = ? WHERE id = ?";

    private final Table table;

    UpdateTable(Table table) {
        this.table = table;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE);
        ps.setInt(1, table.getCapacity());
        ps.setBoolean(2, table.isActive());
        ps.setLong(3, table.getId());

        return ps;
    }
}
