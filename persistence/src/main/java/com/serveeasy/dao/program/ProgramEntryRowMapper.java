package com.serveeasy.dao.program;

import com.serveeasy.model.program.ProgramEntry;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
@Component
class ProgramEntryRowMapper implements RowMapper<ProgramEntry> {

    public ProgramEntry mapRow(ResultSet resultSet, int i) throws SQLException {
        ProgramEntryResultSetExtractor ext = new ProgramEntryResultSetExtractor();
        return ext.extractData(resultSet);
    }
}
