package com.serveeasy.dao.program;

import com.serveeasy.dao.DaoRepository;
import com.serveeasy.model.program.ProgramEntry;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

/**
 *
 */
public class ProgramDaoImplTest extends TestCase {

    private ProgramEntryDao dao;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/serveeasy/context/applicationContext.xml");


        DaoRepository repository = (DaoRepository) ctx.getBean("daoRepository");
        dao = repository.getProgramDao();
    }

    @Test
    public void testSaveWorkProgram() throws Exception {
        ProgramEntry pe = new ProgramEntry(new Date(new DateTime(2010, 12,12, 0,0,0,0).toDate().getTime()), 4, 1, 3);

        dao.saveProgramEntry(pe);
    }

    public void testGetProgram() throws Exception {
        System.out.println(dao.getDayProgramEntries(new DateTime(2010, 12,12, 0,0,0,0)).size());

        System.out.println(dao.getMonthProgramEntries(new DateTime(2010, 12, 12, 0, 0, 0, 0)).size());

        System.out.println(dao.getProgramEntries().size());

    }
}
