package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Update;
import com.serveeasy.model.bar.BarDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
class InsertBarDetails extends Update {

    private static final String query = "INSERT INTO `bar_details` (`image_name`,`image_file_content`,`image_file_mime_type`,`email`,`bar_name`,`country`,`city`,`state`,`zipcode`,`street`) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private final BarDetails barDetails;

    InsertBarDetails(BarDetails barDetails) {
        this.barDetails = barDetails;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, barDetails.getImageName());
        ps.setBytes(2, barDetails.getImageFileContent());
        ps.setString(3, barDetails.getImageFileMimeType());
        ps.setString(4, barDetails.getEmail());
        ps.setString(5, barDetails.getBarName());
        ps.setString(6, barDetails.getCountry());
        ps.setString(7, barDetails.getCity());
        ps.setString(8, barDetails.getState());
        ps.setString(9, barDetails.getZipCode());
        ps.setString(10, barDetails.getStreet());

        return ps;
    }
}
