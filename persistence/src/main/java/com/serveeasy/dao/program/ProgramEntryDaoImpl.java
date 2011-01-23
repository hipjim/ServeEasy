package com.serveeasy.dao.program;

import com.serveeasy.dao.api.Executor;
import com.serveeasy.model.program.ProgramEntry;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 *
 */
@Repository(value = ProgramEntryDao.SPRING_BEAN_NAME)
class ProgramEntryDaoImpl extends Executor<ProgramEntry> implements ProgramEntryDao {

    @Autowired
    public ProgramEntryDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public List<ProgramEntry> getDayProgramEntries(DateTime day) {
        FindDayProgramEntries find = new FindDayProgramEntries(day);
        return executeQuery(find);
    }

    public List<ProgramEntry> getMonthProgramEntries(DateTime month) {
        FindMonthProgramEntries find = new FindMonthProgramEntries(month);
        return executeQuery(find);
    }

    public List<ProgramEntry> getProgramEntries() {
        FindProgramEntries find = new FindProgramEntries();
        return executeQuery(find);
    }

    public void saveProgramEntry(ProgramEntry entry) {
        InsertProgramEntry insert = new InsertProgramEntry(entry);
        executeUpdate(insert);
    }

    public void saveProgramEntries(List<ProgramEntry> entries) {
        for (ProgramEntry entry : entries) {
            InsertProgramEntry insert = new InsertProgramEntry(entry);
            executeUpdate(insert);
        }
    }

    //TODO: logica pe care o s-o folosesc in partea de service pentru a scoate un work program din aceasta
    // todo: lista de entries
//    private WorkProgram extractWorkProgram(List<ProgramEntry> programDays) {
//
//        WorkProgram wp = new WorkProgram();
//
//        for (ProgramEntry programDay : programDays) {
//
//            DateTime dayRecord = new DateTime(programDay.getDate().getTime());
//            long userIdRecord = programDay.getIdUser();
//            User userRecord = usersDao.findUser(userIdRecord);
//            long tableIdRecord = programDay.getIdTable();
//            //todo: aici trebuie sa vina dao de la tabele
//            Table tableRecord = new Table(5, "e doar de test, id:" + tableIdRecord);
//            tableRecord.setId(tableIdRecord);
//
//            //if the day is not in program
//            if (!wp.getProgram().containsKey(dayRecord)) {
//                WorkDay wd = new WorkDay();
//                TableCollection tc = new TableCollection();
//                tc.addTable(tableRecord);
//                wd.assignUserToTables(userRecord, tc);
//                wp.setWorkProgramForDay(dayRecord, wd);
//            } else {
//                WorkDay wd = wp.getWorkDay(dayRecord);
//                //if workday doesn't contains user
//                if (!wd.isUserAssigned(userRecord)) {
//                    TableCollection tc = new TableCollection();
//                    tc.addTable(tableRecord);
//                    wd.assignUserToTables(userRecord, tc);
//                } else {
//                    TableCollection tc = wd.getTablesForUser(userRecord);
//                    if (!tc.contains(tableRecord)) {
//                        tc.addTable(tableRecord);
//                        wd.assignUserToTables(userRecord, tc);
//                    } else {
//                        continue;
//                    }
//                }
//            }
//        }
//        return wp;
//    }
//
//    public void saveProgramEntry(WorkProgram wp) {
//
//        if (wp != null &&
//                wp.getProgram() != null &&
//                wp.getProgram().size() > 0) {
//
//            for (Map.Entry<DateTime, WorkDay> dateAndWorkDay : wp.getProgram().entrySet()) {
//                DateTime date = dateAndWorkDay.getKey();
//                WorkDay wd = dateAndWorkDay.getValue();
//                for (User usr : wd.getUsers()) {
//                    for (Table table : wd.getTablesForUser(usr).getTables()) {
//                        ProgramEntry vo = new ProgramEntry(new Date(date.toDate().getTime()), usr.getId(), table.getId());
//                        InsertProgramEntry insert = new InsertProgramEntry(vo);
//                        executeUpdate(insert);
//                    }
//                }
//            }
//        }
//    }
}
