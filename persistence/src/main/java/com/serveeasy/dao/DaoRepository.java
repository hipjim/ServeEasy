package com.serveeasy.dao;

import com.serveeasy.dao.bar.BarDetailsDao;
import com.serveeasy.dao.program.ProgramEntryDao;
import com.serveeasy.dao.table.TableDao;
import com.serveeasy.dao.users.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * User: cristian.popovici
 */
@Component
public class DaoRepository {

    @Autowired
    private ApplicationContext context;

    private DaoRepository() {
    }

    public TableDao getTableDao() {
        return (TableDao) context.getBean(TableDao.SPRING_BEAN_NAME);
    }

    public UsersDao getUsersDao() {
        return (UsersDao) context.getBean(UsersDao.SPRING_BEAN_NAME);
    }

    public BarDetailsDao getBarDetailsDao() {
        return (BarDetailsDao) context.getBean(BarDetailsDao.SPRING_BEAN_NAME);
    }

    public ProgramEntryDao getProgramDao() {
        return (ProgramEntryDao) context.getBean(ProgramEntryDao.SPRING_BEAN_NAME);
    }
}
