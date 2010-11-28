package com.serveeasy.model.program;

import com.serveeasy.model.users.*;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * User: elvis
 * Date: 22-Nov-2010
 * Time: 20:10:27
 */
public class WorkProgramTest {
    @Test
    public void testSetWorkProgramForDay() throws Exception {

        WorkDay wd = new WorkDay();
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);
        wd.assignUser(usr1);
        wd.assignUser(admin);

        WorkProgram wp = new WorkProgram();
        wp.setWorkProgramForDay(new DateTime(), wd);

        System.out.println(wp);


//        wp.setWorkProgramForWeek(new GregorianCalendar(),wd);
//
//        System.out.println(wp);

//        wp.setWorkProgramForMonth(new GregorianCalendar(),wd);
//
//        System.out.println(wp);

        


    }
}
