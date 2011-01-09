package com.serveeasy.dao.program;

import com.serveeasy.dao.api.Query;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
class FindDayProgramQuery extends Query<ProgramRecordVO> {

    private final static String query = "SELECT `bar_id`,`id`,`day`,`id_user`,`id_table` FROM `serveeasy`.`program` WHERE `day` = ?";

    private DateTime day;

    public FindDayProgramQuery(DateTime day) {
        this.day = day;
    }

    @Override
    public RowMapper<ProgramRecordVO> getRowMapper() {
        return new ProgramRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setDate(1, new Date(day.toDate().getTime()));
        return ps;
    }
}
