package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Executor;
import com.serveeasy.dao.users.UsersDao;
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
        try {
            String query = "INSERT INTO `serveeasy`.`bar_details`" +
                    " SET `email` = '" + barDetails.getEmail() + "', " +
                    " `bar_name` = '" + barDetails.getBarName() + "', " +
                    " `country` = '" + barDetails.getCountry() + "', " +
                    " `city` = '" + barDetails.getCity() + "', " +
                    " `state` = '" + barDetails.getState() + "', " +
                    " `zipcode` = '" + barDetails.getZipCode() + "', " +
                    " `street` = '" + barDetails.getStreet() + "' ";
            if (barDetails.getImageFile() != null) {
                query += ", `image_name` = '" + barDetails.getImageName() + "', " +
                    " `image_file` = '" + new FileInputStream(barDetails.getImageFile()) + "' ";
            }
            jdbcTemplate.update(query);
        } catch (FileNotFoundException e) {
            throw new SystemException("File " + barDetails.getImageName() + " not found");
        }
    }

    public void modifyBarDetails(BarDetails barDetails, int id) {
        try {
            String query = "UPDATE `serveeasy`.`bar_details`" +
                    " SET `email` = '" + barDetails.getEmail() + "', " +
                    " `bar_name` = '" + barDetails.getBarName() + "', " +
                    " `country` = '" + barDetails.getCountry() + "', " +
                    " `city` = '" + barDetails.getCity() + "', " +
                    " `state` = '" + barDetails.getState() + "', " +
                    " `zipcode` = '" + barDetails.getZipCode() + "', " +
                    " `street` = '" + barDetails.getStreet() + "' ";
            if (barDetails.getImageFile() != null) {
                query += ", `image_name` = '" + barDetails.getImageName() + "', " +
                    " `image_file` = '" + new FileInputStream(barDetails.getImageFile()) + "' ";
            }

            query += " WHERE `id` = "+id+"";
            jdbcTemplate.update(query);
        } catch (FileNotFoundException e) {
            throw new SystemException("File " + barDetails.getImageName() + " not found");
        }
    }
}
