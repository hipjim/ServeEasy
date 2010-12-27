package com.serveeasy.dao.program;

import com.serveeasy.model.program.WorkProgram;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Transactional
public interface ProgramDao {

    public static final String SPRING_BEAN_NAME = "programDao";

    public abstract WorkProgram getWorkProgram();

    public abstract void saveWorkProgram(WorkProgram wp);
}