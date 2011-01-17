package com.serveeasy.dao.table;

import com.serveeasy.dao.AbstractSpringTestCase;
import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import static junit.framework.TestCase.assertNotNull;

/**
 * User: cristian.popovici
 */
public class TableDaoTest extends AbstractSpringTestCase {

    @Autowired
    private TableDao dao;

    @Test
    @Rollback(true)
    public void testInsert() throws Exception {
        getLog().info("executing insert");

        Table t = new Table(5);
        t.setBarId(1);
        t.activate();
        dao.insert(t);

        TableCollection collection = dao.getTables(1);
        assertNotNull(collection);
    }

    @Test
    @Rollback(true)
    public void testUpdate() throws Exception {
        Table t = new Table(101);
        t.setId(1);
        dao.update(t);

        dao.find(1);
    }
}
