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
    public void testSetWorkProgramForDay() throws Exception {

        WorkDay wd = new WorkDay();
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        User admin = new UsersFactory().createUser(UserType.ADMIN);
        wd.assignUser(usr1);
        wd.assignUser(admin);

        WorkProgram wp = new WorkProgram();

        DateTime date19 = new DateTime(2010,11,19,0,0,0,0);

        wp.setWorkProgramForDay(date19, wd);

        wp.setWorkProgramForWeek(date19,wd);
        assertEquals(7, wp.getProgram().size());

        wp.setWorkProgramForMonth(date19,wd);
        assertEquals(30, wp.getProgram().size());
        System.out.println(wp);
        

        


    }
}
