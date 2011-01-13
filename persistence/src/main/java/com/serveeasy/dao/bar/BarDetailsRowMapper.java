package com.serveeasy.dao.bar;

import com.serveeasy.model.bar.BarDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
class BarDetailsRowMapper implements RowMapper<BarDetails> {

    public BarDetails mapRow(ResultSet resultSet, int i) throws SQLException {
        BarDetailsResultSetExtractor ext = new BarDetailsResultSetExtractor();
        return ext.extractData(resultSet);
    }
}
