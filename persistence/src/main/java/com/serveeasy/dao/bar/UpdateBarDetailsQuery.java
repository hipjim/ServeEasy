package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Update;
import com.serveeasy.model.bar.BarDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
class UpdateBarDetailsQuery extends Update{

    private static final String query = "UPDATE `bar_details` SET `bar_id`=?,`id`=?,`image_name`=?,`image_file_content`=?,`image_file_mime_type`=?,`email`=?,`bar_name`=?,`country`=?,`city`=?,`state`=?,`zipcode`=?,`street`=? WHERE `id`=?";

    private BarDetails barDetails;

    UpdateBarDetailsQuery(BarDetails user) {
        this.barDetails = user;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, barDetails.getBarId());
        ps.setInt(2, barDetails.getId());
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
        ps.setInt(13, barDetails.getId());

        return ps;
    }
}
