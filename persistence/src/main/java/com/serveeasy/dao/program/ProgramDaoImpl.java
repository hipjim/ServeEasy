package com.serveeasy.dao.program;

import com.serveeasy.dao.api.Executor;
import com.serveeasy.dao.users.UsersDao;
import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import com.serveeasy.model.program.WorkDay;
import com.serveeasy.model.program.WorkProgram;
import com.serveeasy.model.users.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository(value = ProgramDao.SPRING_BEAN_NAME)
class ProgramDaoImpl extends Executor implements ProgramDao {

    @Autowired
    public UsersDao usersDao;

    @Autowired
    public ProgramDaoImpl(DataSource dataSource) {
        super(dataSource);
    }


    public WorkProgram getDayProgram(DateTime day) {
        FindDayProgramQuery find = new FindDayProgramQuery(day);
        List<ProgramRecordVO> records = executeQuery(find);
        WorkProgram wp = extractWorkProgram(records);
        return wp;
    }

    public WorkProgram getMonthProgram(DateTime month) {
        FindMonthProgramQuery find = new FindMonthProgramQuery(month);
        List<ProgramRecordVO> records = executeQuery(find);
        WorkProgram wp = extractWorkProgram(records);
        return wp;
    }

    public WorkProgram getWorkProgram() {
        FindProgramQuery find = new FindProgramQuery();
        List<ProgramRecordVO> programDays = executeQuery(find);
        WorkProgram wp = extractWorkProgram(programDays);
        return wp;
    }

    //todo: business logic in dao - not good :-).
    //todo: Asta ar trebui sa se faca la un nivel superior. in service
    private WorkProgram extractWorkProgram(List<ProgramRecordVO> programDays) {

        WorkProgram wp = new WorkProgram();

        for (ProgramRecordVO programDay : programDays) {

            DateTime dayRecord = new DateTime(programDay.getDate().getTime());
            long userIdRecord = programDay.getIdUser();
            User userRecord = usersDao.getUser(userIdRecord);
            long tableIdRecord = programDay.getIdTable();
            //todo: aici trebuie sa vina dao de la tabele
            Table tableRecord = new Table(tableIdRecord, "e doar de test, id:" + tableIdRecord);

            //if the day is not in program
            if (!wp.getProgram().containsKey(dayRecord)) {
                WorkDay wd = new WorkDay();
                TableCollection tc = new TableCollection();
                tc.addTable(tableRecord);
                wd.assignUserToTables(userRecord, tc);
                wp.setWorkProgramForDay(dayRecord, wd);
            } else {
                WorkDay wd = wp.getWorkDay(dayRecord);
                //if workday doesn't contains user
                if (!wd.isUserAssigned(userRecord)) {
                    TableCollection tc = new TableCollection();
                    tc.addTable(tableRecord);
                    wd.assignUserToTables(userRecord, tc);
                } else {
                    TableCollection tc = wd.getTablesForUser(userRecord);
                    if (!tc.contains(tableRecord)) {
                        tc.addTable(tableRecord);
                        wd.assignUserToTables(userRecord, tc);
                    } else {
                        continue;
                    }
                }
            }
        }
        return wp;
    }

    // todo: same business logic in dao
    public void saveWorkProgram(WorkProgram wp) {

        if (wp != null &&
                wp.getProgram() != null &&
                wp.getProgram().size() > 0) {

            for (Map.Entry<DateTime, WorkDay> dateAndWorkDay : wp.getProgram().entrySet()) {
                DateTime date = dateAndWorkDay.getKey();
                WorkDay wd = dateAndWorkDay.getValue();
                for (User usr : wd.getUsers()) {
                    for (Table table : wd.getTablesForUser(usr).getTables()) {
                        ProgramRecordVO vo = new ProgramRecordVO();
                        vo.setDate(new Date(date.toDate().getTime()));
                        vo.setIdUser(usr.getId());
                        vo.setIdTable(table.getId());
                        InsertProgramQuery insert = new InsertProgramQuery(vo);
                        executeUpdate(insert);
                    }
                }
            }
        }
    }
}
