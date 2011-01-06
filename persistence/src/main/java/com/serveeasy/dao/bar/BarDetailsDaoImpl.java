package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Executor;
import com.serveeasy.model.bar.BarDetails;
import com.serveeasy.model.exceptions.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 */
@Repository(value = BarDetailsDao.SPRING_BEAN_NAME)
class BarDetailsDaoImpl extends Executor<BarDetails> implements BarDetailsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BarDetailsDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    public BarDetails findBarDetails(int id) {
        FindBarDetailsQuery fbd = new FindBarDetailsQuery(id);
        return executeQuery(fbd).get(0);
    }

    public void addBarDetails(BarDetails barDetails) {
        InsertBarDetailsQuery ins = new InsertBarDetailsQuery(barDetails);
        executeUpdate(ins);
    }

    public void modifyBarDetails(BarDetails barDetails) {
        UpdateBarDetailsQuery update = new UpdateBarDetailsQuery(barDetails);
        executeUpdate(update);
    }

    public void deleteBarDetails(int id) {
        DeleteBarDetailsQuery delete = new DeleteBarDetailsQuery(id);
        executeUpdate(delete);
    }
}
