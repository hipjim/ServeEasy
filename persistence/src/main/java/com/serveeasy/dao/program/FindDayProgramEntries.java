package com.serveeasy.dao.program;

import com.serveeasy.dao.api.Query;
import com.serveeasy.model.program.ProgramEntry;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
final class FindDayProgramEntries extends Query<ProgramEntry> {

    private final static String query = "SELECT `id`,`bar_id`,`day`,`id_user`,`id_table` FROM `serveeasy`.`program` WHERE `day` = ?";

    private final DateTime day;

    FindDayProgramEntries(DateTime day) {
        this.day = day;
    }

    @Override
    public RowMapper<ProgramEntry> getRowMapper() {
        return new ProgramEntryRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setDate(1, new Date(day.toDate().getTime()));
        return ps;
    }
}
