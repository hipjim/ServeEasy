package com.serveeasy.dao.bar;

import com.serveeasy.model.bar.BarDetails;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
class BarDetailsResultSetExtractor implements ResultSetExtractor<BarDetails> {

    private static final String ID = "id";
    private static final String IMAGE_NAME = "image_name";
    private static final String IMAGE_FILE_CONTENT = "image_file_content";
    private static final String IMAGE_FILE_MIME_TYPE = "image_file_mime_type";
    private static final String EMAIL = "email";
    private static final String BAR_NAME = "bar_name";
    private static final String COUNTRY = "country";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String ZIPCODE = "zipcode";
    private static final String STREET = "street";


    public BarDetails extractData(ResultSet rs) throws SQLException {
        if (!rs.next()) { return null;}
        BarDetails bd = new BarDetails();
        bd.setId(rs.getLong(ID));
        bd.setImageName(rs.getString(IMAGE_NAME));
        bd.setImageFileContent(rs.getBytes(IMAGE_FILE_CONTENT));
        bd.setImageFileMimeType(rs.getString(IMAGE_FILE_MIME_TYPE));
        bd.setEmail(rs.getString(EMAIL));
        bd.setBarName(rs.getString(BAR_NAME));
        bd.setCountry(rs.getString(COUNTRY));
        bd.setCity(rs.getString(CITY));
        bd.setState(rs.getString(STATE));
        bd.setZipCode(rs.getString(ZIPCODE));
        bd.setStreet(rs.getString(STREET));

        return bd;
    }
}
