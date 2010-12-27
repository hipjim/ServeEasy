package com.serveeasy.dao.program;

import com.serveeasy.dao.DaoRepository;
import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import com.serveeasy.model.program.WorkDay;
import com.serveeasy.model.program.WorkProgram;
import com.serveeasy.model.users.User;
import com.serveeasy.model.users.UserType;
import com.serveeasy.model.users.UsersFactory;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class ProgramDaoImplTest extends TestCase {

    private ProgramDao dao;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/serveeasy/context/applicationContext.xml");


        DaoRepository repository = (DaoRepository) ctx.getBean("daoRepository");
        dao = repository.getProgramDao();
    }

    @Test
    public void testSaveWorkProgram() throws Exception {
        Table t1 = new Table(3, "t1");
        t1.setTableId(1);
        Table t2 = new Table(3, "t2");
        t2.setTableId(2);
        Table t3 = new Table(3, "t3");
        t3.setTableId(3);
        Table t4 = new Table(3, "t4");
        t4.setTableId(4);
        Table t5 = new Table(3, "t5");
        t5.setTableId(5);
        Table t6 = new Table(3, "t6");
        t6.setTableId(6);
        Table t7 = new Table(3, "t7");
        t7.setTableId(7);
        Table t8 = new Table(3, "t8");
        t8.setTableId(8);
        Table t9 = new Table(3, "t9");
        t9.setTableId(9);

        TableCollection tc1 = new TableCollection();
        tc1.addTable(t1);
        tc1.addTable(t2);
        tc1.addTable(t3);
        tc1.addTable(t4);
        tc1.addTable(t5);

        TableCollection tc3 = new TableCollection();
        tc3.addTable(t6);
        tc3.addTable(t7);
        tc3.addTable(t8);
        tc3.addTable(t9);
        tc3.addTable(t5);

        WorkDay wd = new WorkDay();
        User usr1 = new UsersFactory().createUser(UserType.EMPLOYEE);
        usr1.setUserId(1);
        User admin = new UsersFactory().createUser(UserType.ADMIN);
        admin.setUserId(2);
        wd.assignUserToTables(usr1, tc1);
        wd.assignUserToTables(admin, tc3);

        WorkProgram wp = new WorkProgram();
        DateTime date19 = new DateTime(2010, 11, 19, 0, 0, 0, 0);

        wp.setWorkProgramForYear(date19, wd);


//        dao.saveWorkProgram(wp);

        System.out.println(dao.getWorkProgram());
    }
}
