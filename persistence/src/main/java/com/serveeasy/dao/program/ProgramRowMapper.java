package com.serveeasy.dao.program;

import com.serveeasy.model.program.WorkProgram;
import com.serveeasy.model.users.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
class ProgramRowMapper implements RowMapper {

    private WorkProgram wp;

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ProgramResultSetExtractor ext  = new ProgramResultSetExtractor();
        ext.setWorkProgram(getWorkProgram());
        return ext.extractData(resultSet);
    }

    public WorkProgram getWorkProgram() {
        return wp;
    }

    public void setWorkProgram(WorkProgram wp) {
        this.wp = wp;
    }
}
