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
final class FindActiveUsers extends Query<User> {

    private final static String query = "SELECT `id`,`username`,`password`,`fullname`,`is_admin`,`active`,`is_with_privileges` FROM `serveeasy`.`users` WHERE `active` = ?";

    private final boolean active;

    FindActiveUsers(boolean active) {
        this.active = active;
    }

    @Override
    public RowMapper<User> getRowMapper() {
        return new UserRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setBoolean(1, active);

        return ps;
    }
}
