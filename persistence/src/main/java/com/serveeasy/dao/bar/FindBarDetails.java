package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Find;
import com.serveeasy.dao.api.Query;
import com.serveeasy.model.bar.BarDetails;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
class FindBarDetails extends Find<BarDetails> {

    private final static String query = "SELECT `id`,`image_name`,`image_file_content`,`image_file_mime_type`,`email`,`bar_name`,`country`,`city`,`state`,`zipcode`,`street` FROM `serveeasy`.`bar_details` WHERE `id` = ?";

    private final long id;

    public FindBarDetails(long id) {
        this.id = id;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);

        return ps;
    }

    @Override
    public ResultSetExtractor<BarDetails> getResultSetExtractor() {
        return new BarDetailsResultSetExtractor();
    }
}
