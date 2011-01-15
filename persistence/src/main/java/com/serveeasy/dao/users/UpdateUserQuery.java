package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Update;
import com.serveeasy.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class UpdateUserQuery extends Update {

    private static final String query = "UPDATE `serveeasy`.`users` SET `username` = ?, `password` = ?, `fullname` = ?, `is_admin` = ?, `active` = ?, `is_with_privileges` = ? WHERE `id` = ?";

    private User user;

    UpdateUserQuery(User user) {
        this.user = user;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getFullname());
        ps.setBoolean(4, user.isAdmin());
        ps.setBoolean(5, user.isActive());
        ps.setBoolean(6, user.isWithPrivileges());
        ps.setLong(7, user.getId());

        return ps;
    }
}