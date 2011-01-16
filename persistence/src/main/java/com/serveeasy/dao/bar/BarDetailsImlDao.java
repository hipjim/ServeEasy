package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Executor;
import com.serveeasy.model.bar.BarDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 *
 */
@Repository(value = BarDetailsDao.SPRING_BEAN_NAME)
class BarDetailsImlDao extends Executor<BarDetails> implements BarDetailsDao {

    @Autowired
    BarDetailsImlDao(DataSource dataSource) {
        super(dataSource);
    }

    public void insert(BarDetails barDetails) {
        InsertBarDetails insert = new InsertBarDetails(barDetails);
        executeUpdate(insert);
    }

    public void update(BarDetails barDetails) {
        UpdateBarDetails update = new UpdateBarDetails(barDetails);
        executeUpdate(update);
    }

    public BarDetails find(long id) {
        FindBarDetails query = new FindBarDetails(id);
        return executeFind(query);
    }

    public void delete(long id) {
        DeleteBarDetails delete = new DeleteBarDetails(id);
        executeUpdate(delete);
    }
}
