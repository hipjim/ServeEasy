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

    private static final String query = "INSERT INTO `serveeasy`.`users`INTO (`bar_id`,`id`,`username`,`password`,`fullname`,`is_admin`,`active`,`is_with_privileges`) VALUES (?,?,?,?,?,?,?,?)";

    private final User user;

    InsertUser(User user) {
        this.user = user;
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, user.getBarId());
        ps.setInt(2, user.getId());
        ps.setString(3, user.getUsername());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getFullname());
        ps.setBoolean(6, user.isAdmin());
        ps.setBoolean(7, user.isActive());
        ps.setBoolean(8, user.isWithPrivileges());
        return ps;
    }
}
