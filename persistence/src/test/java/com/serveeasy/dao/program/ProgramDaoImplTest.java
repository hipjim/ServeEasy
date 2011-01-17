package com.serveeasy.dao.program;

import com.serveeasy.dao.AbstractSpringTestCase;
import com.serveeasy.model.program.ProgramEntry;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 *
 */
public class ProgramDaoImplTest extends AbstractSpringTestCase {

    @Autowired
    private ProgramEntryDao dao;

    @Test
    public void testSaveWorkProgram() throws Exception {
        ProgramEntry pe = new ProgramEntry(new Date(new DateTime(2010, 12, 12, 0, 0, 0, 0).toDate().getTime()), 4, 1, 3);

        dao.saveProgramEntry(pe);
    }

    @Test
    public void testGetProgram() throws Exception {
        System.out.println(dao.getDayProgramEntries(new DateTime(2010, 12, 12, 0, 0, 0, 0)).size());

        System.out.println(dao.getMonthProgramEntries(new DateTime(2010, 12, 12, 0, 0, 0, 0)).size());

        System.out.println(dao.getProgramEntries().size());

    }
}
