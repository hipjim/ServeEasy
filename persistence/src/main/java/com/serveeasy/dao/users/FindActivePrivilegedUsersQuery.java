package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Query;
import com.serveeasy.model.users.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
final class FindActivePrivilegedUsersQuery extends Query<User> {

    private final static String query = "SELECT `bar_id`,`id`,`username`,`password`,`fullname`,`is_admin`,`active`,`is_with_privileges` FROM `serveeasy`.`users` WHERE `active` = ? AND `is_with_privileges` = ?";

    private boolean active;
    private boolean isWithPrivileges;

    public FindActivePrivilegedUsersQuery(boolean active, boolean isWithPrivileges) {
        this.active = active;
        this.isWithPrivileges = isWithPrivileges;
    }

    @Override
    public RowMapper<User> getRowMapper() {
        return new UserRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setBoolean(1, active);
        ps.setBoolean(2, isWithPrivileges);
        return ps;
    }
}