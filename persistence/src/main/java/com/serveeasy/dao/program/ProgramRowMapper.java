package com.serveeasy.dao.program;

import com.serveeasy.model.program.WorkProgram;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
@Component
class ProgramRowMapper implements RowMapper<ProgramRecordVO> {

    public ProgramRecordVO mapRow(ResultSet resultSet, int i) throws SQLException {
        ProgramResultSetExtractor ext = new ProgramResultSetExtractor();
        return ext.extractData(resultSet);
    }
}
