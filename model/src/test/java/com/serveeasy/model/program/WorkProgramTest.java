package com.serveeasy.model.program;

import com.serveeasy.model.AbstractTestCase;
import com.serveeasy.model.users.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.junit.Test;

/**
 * User: elvis
 * Date: 22-Nov-2010
 * Time: 20:10:27
 */
public class WorkProgramTest extends AbstractTestCase {

    @Test
    public void testSetWorkProgramForDayWeekAndMonth() throws Exception {

        WorkDay wd = new WorkDay();
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);
        wd.assignUser(usr1);
        wd.assignUser(admin);

        WorkProgram wp = new WorkProgram();

        DateTime date19 = new DateTime(2010, 11, 19, 0, 0, 0, 0);

        wp.setWorkProgramForDay(date19, wd);

        wp.setWorkProgramForWeek(date19, wd);
        assertEquals(7, wp.getProgram().size());

        wp.setWorkProgramForMonth(date19, wd);
        assertEquals(30, wp.getProgram().size());
    }


    @Test
    public void testSetWorkProgramForYear() throws Exception {
        WorkDay wd = new WorkDay();
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);
        wd.assignUser(usr1);
        wd.assignUser(admin);

        WorkProgram wp = new WorkProgram();
        DateTime date19 = new DateTime(2010, 11, 19, 0, 0, 0, 0);

        wp.setWorkProgramForYear(date19, wd);
        assertEquals(365, wp.getProgram().size());
        System.out.println(wp);
    }

    @Test
    public void testCopyWorkProgramFromDayToDay() throws Exception {
        WorkDay wd = new WorkDay();
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);
        wd.assignUser(usr1);
        wd.assignUser(admin);

        WorkProgram wp = new WorkProgram();
        DateTime date19 = new DateTime(2010, 11, 19, 0, 0, 0, 0);
        DateTime date21 = new DateTime(2010, 11, 21, 0, 0, 0, 0);

        wp.setWorkProgramForDay(date19, wd);

        assertEquals(1, wp.getProgram().size());
        assertEquals(2, wp.getProgram().get(date19).getUsers().size());

        wp.copyWorkProgramFromDayToDay(date19, date21);

        assertEquals(2, wp.getProgram().size());
        assertEquals(2, wp.getProgram().get(date21).getUsers().size());
    }

    @Test
    public void testCopyWorkProgramFromDayToWeek() throws Exception {
        WorkDay wd = new WorkDay();
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);
        wd.assignUser(usr1);
        wd.assignUser(admin);

        WorkProgram wp = new WorkProgram();
        DateTime date19 = new DateTime(2010, 11, 19, 0, 0, 0, 0);
        DateTime date2 = new DateTime(2010, 11, 2, 0, 0, 0, 0);

        wp.setWorkProgramForDay(date19, wd);

        assertEquals(1, wp.getProgram().size());
        assertEquals(2, wp.getProgram().get(date19).getUsers().size());

        wp.copyWorkProgramFromDayToWeek(date19, date2);

        System.out.println(wp);

        assertEquals(8, wp.getProgram().size());
        assertEquals(2, wp.getProgram().get(date2).getUsers().size());
    }

    @Test
    public void testCopyWorkProgramFromDayToMonth() throws Exception {
        WorkDay wd = new WorkDay();
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);
        wd.assignUser(usr1);
        wd.assignUser(admin);

        WorkProgram wp = new WorkProgram();
        DateTime date19 = new DateTime(2010, 11, 19, 0, 0, 0, 0);
        DateTime date2 = new DateTime(2010, 10, 2, 0, 0, 0, 0);

        wp.setWorkProgramForDay(date19, wd);

        assertEquals(1, wp.getProgram().size());
        assertEquals(2, wp.getProgram().get(date19).getUsers().size());

        wp.copyWorkProgramFromDayToMonth(date19, date2);

        assertEquals(32, wp.getProgram().size());
        assertEquals(2, wp.getProgram().get(date2).getUsers().size());

        wp.copyWorkProgramFromDayToMonth(date19, date19);

        System.out.println(wp);

        assertEquals(61, wp.getProgram().size());
        assertEquals(2, wp.getProgram().get(date19).getUsers().size());
    }


    @Test
    public void testCopyWorkProgramFromWeekToWeek() throws Exception {
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);

        WorkDay wd19 = new WorkDay();
        wd19.assignUser(usr1);
        wd19.assignUser(admin);

        WorkDay wd20 = new WorkDay();
        wd20.assignUser(usr1);

        WorkDay wd21 = new WorkDay();
        wd21.assignUser(admin);

        WorkProgram wp = new WorkProgram();
        DateTime date19 = new DateTime(2010, 11, 19, 0, 0, 0, 0);
        DateTime date20 = new DateTime(2010, 11, 20, 0, 0, 0, 0);
        DateTime date21 = new DateTime(2010, 11, 21, 0, 0, 0, 0);
        DateTime dateTo = new DateTime(2010, 11, 10, 0, 0, 0, 0);

        wp.setWorkProgramForDay(date19, wd19);
        wp.setWorkProgramForDay(date20, wd20);
        wp.setWorkProgramForDay(date21, wd21);

        assertEquals(3, wp.getProgram().size());

        wp.copyWorkProgramFromWeekToWeek(date19, dateTo);

        System.out.println(wp);

        assertEquals(6, wp.getProgram().size());
    }

    @Test
    public void testGetWorkDay() throws Exception {
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);

        WorkDay wd19 = new WorkDay();
        wd19.assignUser(usr1);
        wd19.assignUser(admin);

        WorkProgram wp = new WorkProgram();
        DateTime date19 = new DateTime(2010, 11, 19, 0, 0, 0, 0);

        wp.setWorkProgramForDay(date19, wd19);

        assertEquals(2, wp.getWorkDay(date19).getUsers().size());
        assertEquals(2, wp.getWorkDay(new DateTime(2010, 11, 19, 0, 0, 0, 0)).getUsers().size());
    }


    @Test
    public void testGetWorkWeekAndMonth() throws Exception {
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);

        WorkDay wd19 = new WorkDay();
        wd19.assignUser(usr1);
        wd19.assignUser(admin);

        WorkProgram wp = new WorkProgram();
        DateTime date19 = new DateTime(2010, 12, 19, 0, 0, 0, 0);
        DateTime date12 = new DateTime(2010, 12, 8, 0, 0, 0, 0);
        DateTime date1 = new DateTime(2010, 1, 1, 0, 0, 0, 0);

        wp.setWorkProgramForWeek(date19, wd19);
        wp.copyWorkProgramFromDayToWeek(date19, date12);

        assertEquals(14, wp.getProgram().size());
        assertEquals(7, wp.getWorkWeek(date12).size());

        wp.copyWorkProgramFromDayToMonth(date19, date1);

        assertEquals(31, wp.getWorkMonth(date1).size());
    }


    @Test
    public void testRemove() throws Exception {
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);

        WorkDay wd19 = new WorkDay();
        wd19.assignUser(usr1);
        wd19.assignUser(admin);

        WorkProgram wp = new WorkProgram();
        DateTime date19 = new DateTime(2010, 12, 19, 0, 0, 0, 0);
        DateTime date12 = new DateTime(2010, 12, 8, 0, 0, 0, 0);
        DateTime date1 = new DateTime(2010, 1, 1, 0, 0, 0, 0);

        wp.setWorkProgramForWeek(date19, wd19);
        wp.copyWorkProgramFromDayToWeek(date19, date12);

        assertEquals(14, wp.getProgram().size());
        assertEquals(7, wp.getWorkWeek(date12).size());

        wp.copyWorkProgramFromDayToMonth(date19, date1);

        assertEquals(45, wp.getProgram().size());
        assertEquals(7, wp.getWorkWeek(date12).size());
        assertEquals(31, wp.getWorkMonth(date1).size());

        wp.removeWorkDay(date1);
        assertEquals(30, wp.getWorkMonth(date1).size());

        wp.removeWorkWeek(date1);
        assertEquals(28, wp.getWorkMonth(date1).size());

        wp.removeWorkMonth(date1);
        assertEquals(0, wp.getWorkMonth(date1).size());




    }


}
