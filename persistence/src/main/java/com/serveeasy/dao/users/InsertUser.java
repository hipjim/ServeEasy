package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Update;
import com.serveeasy.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * User: cristian.popovici
 */
final class InsertUser extends Update {

    private static final String query = "INSERT INTO `serveeasy`.`users` (`bar_id`, `username`,`password`,`fullname`,`is_admin`,`active`,`is_with_privileges`) VALUES (?,?,?,?,?,?,?)";

    private final User user;

    InsertUser(User user) {
        this.user = user;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, user.getBarId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getFullname());
        ps.setBoolean(5, user.isAdmin());
        ps.setBoolean(6, user.isActive());
        ps.setBoolean(7, user.isWithPrivileges());
        return ps;
    }
}
