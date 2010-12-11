package com.serveeasy.dao;

import com.serveeasy.dao.table.TableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: cristian.popovici
 * Date: Dec 11, 2010
 * Time: 1:16:56 PM
 */
@Component
public class DaoRepository {

    @Autowired
    private ApplicationContext context;

    private DaoRepository() {
    }

    private static class Daoholder {
        private static DaoRepository INSTANCE = new DaoRepository();
    }

    public static DaoRepository getInstance() {
        return Daoholder.INSTANCE;
    }

    public TableDao getTableDao() {
        return (TableDao) context.getBean(TableDao.SPRING_BEAN_NAME);
    }
}
