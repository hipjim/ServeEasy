package com.serveeasy.dao.table;

import com.serveeasy.dao.DaoRepository;
import com.serveeasy.model.bar.Table;
import junit.framework.TestCase;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: cristian.popovici
 */
public class TableDaoTest extends TestCase {

    private TableDao dao;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/serveeasy/context/applicationContext.xml");
        DaoRepository repository = (DaoRepository) ctx.getBean("daoRepository");
        dao = repository.getTableDao();
    }

    public void testInsert() throws Exception {
        Table t = new Table(5);
        t.setBarId(1);
        t.activate();
        dao.insert(t);
    }

    public void testUpdate() throws Exception {
        Table t = new Table(10);
        t.setId(1);
        dao.update(t);
    }
}
