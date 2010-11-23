package com.serveeasy.model.program;

import com.serveeasy.model.users.AdminUser;
import com.serveeasy.model.users.EmployeeUser;
import com.serveeasy.model.users.User;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * User: elvis
 * Date: 22-Nov-2010
 * Time: 20:10:27
 */
public class WorkProgramTest {
    @Test
    public void testSetWorkProgramForDay() throws Exception {

        WorkDay wd = new WorkDay();
        User usr1 = new EmployeeUser();
        User admin = new AdminUser();
        wd.assignUser(usr1);
        wd.assignUser(admin);

        WorkProgram wp = new WorkProgram();
//        wp.setWorkProgramForDay(new GregorianCalendar(), wd);

//        System.out.println(wp);


//        wp.setWorkProgramForWeek(new GregorianCalendar(),wd);
//
//        System.out.println(wp);

        wp.setWorkProgramForMonth(new GregorianCalendar(),wd);

        System.out.println(wp);


    }
}
