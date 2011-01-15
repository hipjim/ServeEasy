package com.serveeasy.dao.table;

import com.serveeasy.dao.api.Executor;
import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.List;

/**
 * User: cristian.popovici
 */
@Repository(value = TableDao.SPRING_BEAN_NAME)
class TableDaoImpl extends Executor<Table> implements TableDao {

    @Autowired
    TableDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public Table find(long tableId) {
        return executeQuery(new FindTable(tableId)).get(0);
    }

    public void insert(Table table) {
        executeUpdate(new InsertTable(table));
    }

    public void update(Table table) {
        executeUpdate(new UpdateTable(table));
    }

    public void delete(long id) {
        executeUpdate(new DeleteTable(id));
    }

    public TableCollection getTables(long barId) {
        List<Table> result = executeQuery(new FindBarTables(barId));
        return new TableCollection(new HashSet(result));
    }
}
