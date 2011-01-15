package com.serveeasy.dao.table;

import com.serveeasy.dao.api.Update;
import com.serveeasy.model.bar.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * User: cristian.popovici
 */
final class InsertTable extends Update {

    private static final String QUERY = "INSERT INTO tables(bar_id, capacity, status) values (?,?,?)";

    private final Table table;

    InsertTable(Table table) {
        this.table = table;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ps.setLong(1, table.getBarId());
        ps.setInt(2, table.getCapacity());
        ps.setBoolean(3, table.isActive());

        return ps;
    }
}
