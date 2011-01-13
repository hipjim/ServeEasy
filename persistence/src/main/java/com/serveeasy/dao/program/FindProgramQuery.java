package com.serveeasy.dao.program;

import com.serveeasy.dao.api.Query;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * todo: redenumit in FindProgram
 */
class FindProgramQuery extends Query<ProgramRecordVO> {

    private final static String query = "SELECT `bar_id`,`id`,`day`,`id_user`,`id_table` FROM `serveeasy`.`program`";

    @Override
    public RowMapper<ProgramRecordVO> getRowMapper() {
        return new ProgramRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        return ps;
    }
}
