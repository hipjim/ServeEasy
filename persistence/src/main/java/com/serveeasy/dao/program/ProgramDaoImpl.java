package com.serveeasy.dao.program;

import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import com.serveeasy.model.program.WorkDay;
import com.serveeasy.model.program.WorkProgram;
import com.serveeasy.model.users.User;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository(value = ProgramDao.SPRING_BEAN_NAME)
class ProgramDaoImpl implements ProgramDao {
    private JdbcTemplate jdbcTemplate;
    private WorkProgram workProgram;
    private DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");

    @Autowired
    public ProgramDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
//        workProgram = getWorkProgram();
    }

    //todo: trebuie sa scot logica de a creat WorkProgram din extractor pentru ca foloseste dao
    //todo: dao ar trebui folosit la acelasi nivel adica de restul obiectelor dao
    public WorkProgram getWorkProgram() {
        WorkProgram wp = new WorkProgram();
        String query = "SELECT * FROM `serveeasy`.`program` ";
        //todo: am voie sa folosesc asa ceva? vor fi probleme ?
        ProgramRowMapper prm = new ProgramRowMapper();
        prm.setWorkProgram(wp);
        jdbcTemplate.query(query, prm);

        return wp;
    }

    //todo : setWorkProgramForDay, forMonth, for Week
    //todo: getWorkProgramForDay, forMOnth, for Week, year ???

    public void saveWorkProgram(WorkProgram wp) {
        if (wp != null &&
                wp.getProgram() != null &&
                wp.getProgram().size() > 0) {
            String query = "";
            for (Map.Entry<DateTime, WorkDay> dateAndWorkDay : wp.getProgram().entrySet()) {
                DateTime date = dateAndWorkDay.getKey();
                WorkDay wd = dateAndWorkDay.getValue();
                for (User usr : wd.getUsers()) {
                    for (Table table : wd.getTablesForUser(usr).getTables()) {
                        query = "INSERT INTO `serveeasy`.`program` " +
                                " SET `day` = '" + dtf.print(date) + "', " +
                                " `id_user` = " + usr.getId() + ", " +
                                " `id_table` = " + table.getId() + "";
                        jdbcTemplate.update(query);
                    }
                }
            }
        }
    }

}
