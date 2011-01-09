package com.serveeasy.dao.program;

import com.serveeasy.dao.api.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
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
        ps.setInt(1, record.getBarId());
        ps.setInt(2, record.getId());
        ps.setDate(3, record.getDate());
        ps.setInt(4, record.getIdUser());
        ps.setInt(5, record.getIdTable());
        return ps;
    }
}
