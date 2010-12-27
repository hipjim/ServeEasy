package com.serveeasy.dao.program;

import com.serveeasy.dao.table.TableDao;
import com.serveeasy.dao.users.UsersDao;
import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import com.serveeasy.model.program.WorkDay;
import com.serveeasy.model.program.WorkProgram;
import com.serveeasy.model.users.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

class ProgramResultSetExtractor implements ResultSetExtractor {

    private WorkProgram wp;

    @Autowired
    private UsersDao usersDao;

    @Autowired //todo: de ce nu merge chestia asta?
    private TableDao tableDao;

    public WorkProgram getWorkProgram() {
        return wp;
    }

    public void setWorkProgram(WorkProgram wp) {
        this.wp = wp;
    }

    public Object extractData(ResultSet rs) throws SQLException {
        DateTime date = new DateTime(rs.getDate("day").getTime());

        if (wp.getWorkDay(date) == null) {
            WorkDay wd = new WorkDay();
            User user = usersDao.getUser(rs.getInt("id_user"));
            //todo: asa ar trebui, pana cand va fi reparata metoda
//            Table t = tableDao.find(rs.getInt("id_table"));
            //todo: pana una alta
            Table t = new Table(3, "test table");
            t.setTableId(456);
            TableCollection tc = wd.getTablesForUser(user);

            if (tc != null) {
                 if (!tc.contains(t)) {
                     tc.addTable(t);
                 }
            } else {
                tc = new TableCollection();
                tc.addTable(t);
            }
            wd.assignUserToTables(user, tc);
            wp.setWorkProgramForDay(date, wd);
        }
         return null;
    }
}
