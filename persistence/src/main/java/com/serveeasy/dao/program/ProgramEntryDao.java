package com.serveeasy.dao.program;

import com.serveeasy.model.program.ProgramEntry;
import com.serveeasy.model.program.WorkProgram;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Transactional
public interface ProgramEntryDao {

    public static final String SPRING_BEAN_NAME = "programDao";

    public abstract List<ProgramEntry> getProgramEntries();

    public abstract void saveProgramEntry(ProgramEntry entry);

    public abstract void saveProgramEntries(List<ProgramEntry> entries);

    List<ProgramEntry> getDayProgramEntries(DateTime day);

    List<ProgramEntry> getMonthProgramEntries(DateTime month);
}