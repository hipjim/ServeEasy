package com.serveeasy.dao.program;

import com.serveeasy.model.program.ProgramEntry;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
class ProgramEntryResultSetExtractor implements ResultSetExtractor<ProgramEntry> {

    private static final String DAY = "day";
    private static final String ID_USER = "id_user";
    private static final String ID_TABLE = "id_table";
    private static final String BAR_ID = "bar_id";

    public ProgramEntry extractData(ResultSet rs) throws SQLException {
        ProgramEntry vo = new ProgramEntry(rs.getDate(DAY), rs.getLong(ID_USER), rs.getLong(ID_TABLE), rs.getLong(BAR_ID));
        return vo;
    }
}
