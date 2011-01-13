package com.serveeasy.dao.program;

import com.serveeasy.dao.api.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * todo: redenumit in InsertProgram
 */
class InsertProgramQuery extends Update{

    private static final String query = "INSERT INTO `serveeasy`.`program` SET `bar_id` = ?,`id` = ?,`day` = ?,`id_user` = ?, `id_table` = ?";

    private ProgramRecordVO record;

    InsertProgramQuery(ProgramRecordVO record) {
        this.record = record;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, record.getBarId());
        ps.setLong(2, record.getId());
        ps.setDate(3, record.getDate());
        ps.setLong(4, record.getIdUser());
        ps.setLong(5, record.getIdTable());
        return ps;
    }
}
