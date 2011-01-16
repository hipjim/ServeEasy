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
final class FindPrivilegedUsers extends Query<User> {
     private final static String query = "SELECT `id`,`username`,`password`,`fullname`,`is_admin`,`active`,`is_with_privileges` FROM `serveeasy`.`users` WHERE `is_with_privileges` = ?";

    private boolean is_with_privileges;

    public FindPrivilegedUsers(boolean is_with_privileges) {
        this.is_with_privileges = is_with_privileges;
    }

    @Override
    public RowMapper<User> getRowMapper() {
        return new UserRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setBoolean(1, is_with_privileges);

        return ps;
    }
}
