package com.serveeasy.dao.table;

import com.serveeasy.model.bar.Bar;
import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * User: cristian.popovici
 */
@Repository(value = TableDao.SPRING_BEAN_NAME)
class TableDaoImpl implements TableDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TableDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public Table find(long tableId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void merge(Table table) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(Table table) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<TableCollection> getTables(Bar bar) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
