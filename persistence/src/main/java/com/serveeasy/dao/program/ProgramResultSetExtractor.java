package com.serveeasy.dao.program;

import com.serveeasy.dao.table.TableDao;
import com.serveeasy.dao.users.UsersDao;
import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import com.serveeasy.model.program.WorkDay;
import com.serveeasy.model.users.User;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
class ProgramResultSetExtractor implements ResultSetExtractor {

    private static final String BAR_ID = "bar_id";
    private static final String ID = "id";
    private static final String DAY = "day";
    private static final String ID_USER = "id_user";
    private static final String ID_TABLE = "id_table";

    public ProgramRecordVO extractData(ResultSet rs) throws SQLException {
        ProgramRecordVO vo = new ProgramRecordVO();
        vo.setBarId(rs.getInt(BAR_ID));
        vo.setId(rs.getInt(ID));
        vo.setDate(rs.getDate(DAY));
        vo.setIdUser(rs.getInt(ID_USER));
        vo.setIdTable(rs.getInt(ID_TABLE));
        return vo;
    }
}
