package com.serveeasy.dao.table;

import com.serveeasy.dao.api.Query;
import com.serveeasy.model.bar.Table;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * User: cristian.popovici
 */
final class FindBarTables extends Query<Table> {

    private final String QUERY = "SELECT id, bar_id, capacity, status from tables where bar_id = ?";

    private final long barId;

    FindBarTables(long barId) {
        this.barId = barId;
    }

    @Override
    public RowMapper<Table> getRowMapper() {
        return new TableRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ps.setLong(1, barId);

        return ps;
    }
}
