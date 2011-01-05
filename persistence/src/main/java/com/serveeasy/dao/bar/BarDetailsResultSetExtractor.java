package com.serveeasy.dao.bar;

import com.serveeasy.model.bar.BarDetails;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
class BarDetailsResultSetExtractor {

    private static final String BAR_ID = "bar_id";
    private static final String ID = "id";
    private static final String IMAGE_NAME = "image_name";
    private static final String IMAGE_FILE = "image_file";
    private static final String EMAIL = "email";
    private static final String BAR_NAME = "bar_name";
    private static final String COUNTRY = "country";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String ZIPCODE = "zipcode";
    private static final String STREET = "street";


    public BarDetails extractData(ResultSet rs) throws SQLException {
        BarDetails bd = new BarDetails();
        bd.setBarId(rs.getInt(BAR_ID));
        bd.setId(rs.getInt(ID));
        bd.setImageName(rs.getString(IMAGE_NAME));
        //todo:
//        bd.setImageFile(new File()rs.getBlob(IMAGE_FILE));
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
