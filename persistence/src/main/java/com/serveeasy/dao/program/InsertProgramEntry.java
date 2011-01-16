package com.serveeasy.dao.program;

import com.serveeasy.dao.api.Update;
import com.serveeasy.model.program.ProgramEntry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
class InsertProgramEntry extends Update{

    private static final String query = "INSERT INTO `serveeasy`.`program` SET `day` = ?,`id_user` = ?, `id_table` = ?, `bar_id` = ?";

    private ProgramEntry record;

    InsertProgramEntry(ProgramEntry record) {
        this.record = record;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setDate(1, record.getDate());
        ps.setLong(2, record.getIdUser());
        ps.setLong(3, record.getIdTable());
        ps.setLong(4, record.getBarId());
//        System.out.println(ps);
        return ps;
    }
}
