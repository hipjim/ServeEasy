package com.serveeasy.dao.program;

import com.serveeasy.dao.api.Query;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
class FindMonthProgramQuery extends Query<ProgramRecordVO> {

    private final static String query = "SELECT `bar_id`,`id`,`day`,`id_user`,`id_table` FROM `serveeasy`.`program` WHERE `day` LIKE ?";

    private DateTime month;

    public FindMonthProgramQuery(DateTime month) {
        this.month = month;
    }

    @Override
    public RowMapper<ProgramRecordVO> getRowMapper() {
        return new ProgramRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, month.toString("yyyy-MM")+"%");

        System.out.println(ps.toString());

        return ps;
    }
}
