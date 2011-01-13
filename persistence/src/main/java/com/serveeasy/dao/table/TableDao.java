package com.serveeasy.dao.table;

import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: cristian.popovici
 * Date: Dec 11, 2010
 * Time: 12:59:06 PM
 */
@Transactional
public interface TableDao {

    public static final String SPRING_BEAN_NAME = "tableDao";

    public Table find(long tableId);

    public void merge(Table table);

    public void delete(Table table);

    public List<TableCollection> getTables(long barId);

}
