package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Update;
import com.serveeasy.model.bar.BarDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * todo: PK-ul (ID) cum il obtinem? auto increment in DB? sau il generam noi. Daca il generam ne trebuie un mecanism de generat secvete
 * todo: redenimit in InsertBarDetails
 *
 */
class InsertBarDetailsQuery extends Update {

    private static final String query = "INSERT INTO `bar_details` (`bar_id`,`id`,`image_name`,`image_file_content`,`image_file_mime_type`,`email`,`bar_name`,`country`,`city`,`state`,`zipcode`,`street`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private final BarDetails barDetails;

    InsertBarDetailsQuery(BarDetails barDetails) {
        this.barDetails = barDetails;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, barDetails.getBarId());
        ps.setLong(2, barDetails.getId());
        ps.setString(3, barDetails.getImageName());
        ps.setBytes(4, barDetails.getImageFileContent());
        ps.setString(5, barDetails.getImageFileMimeType());
        ps.setString(6, barDetails.getEmail());
        ps.setString(7, barDetails.getBarName());
        ps.setString(8, barDetails.getCountry());
        ps.setString(9, barDetails.getCity());
        ps.setString(10, barDetails.getState());
        ps.setString(11, barDetails.getZipCode());
        ps.setString(12, barDetails.getStreet());

        return ps;
    }
}
