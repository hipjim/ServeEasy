package com.serveeasy.dao.table;

import com.serveeasy.dao.api.Executor;
import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * User: cristian.popovici
 */
@Repository(value = TableDao.SPRING_BEAN_NAME)
class TableDaoImpl extends Executor<Table> implements TableDao {

    @Autowired
    public TableDaoImpl(DataSource dataSource) {
        super(dataSource);
    }


    public Table find(long tableId) {
        return null;
    }

    public void merge(Table table) {
    }

    public void delete(Table table) {
    }

    public List<TableCollection> getTables(long barId) {
        return null;
    }
}
