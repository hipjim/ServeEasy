package com.serveeasy.dao.table;

import com.serveeasy.model.bar.Table;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: cristian.popovici
 */
final class TableRowMapper implements RowMapper<Table> {

    private static final String BAR_ID = "bar_id";
    private static final String STATUS = "status";
    private static final String CAPACITY = "capacity";

    public Table mapRow(ResultSet rs, int i) throws SQLException {
        final long barId = rs.getLong(BAR_ID);
        final boolean status = rs.getBoolean(STATUS);
        final int capacity = rs.getInt(CAPACITY);

        final Table table = new Table(capacity);
        table.setBarId(barId);
        if (status) {
            table.activate();
        }

        return table;
    }
}
