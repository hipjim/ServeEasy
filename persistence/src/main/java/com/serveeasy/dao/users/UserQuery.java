package com.serveeasy.dao.users;

import com.serveeasy.dao.api.Query;
import com.serveeasy.model.users.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * User: cristian.popovici
 */
final class UserQuery extends Query<User> {

    private static final String QUERY = "SELECT `bar_id`,`id`,`username`,`password`,`fullname`,`is_admin`,`active`,`is_with_privileges` FROM `serveeasy`.`users` WHERE `id` = ?";

    private final long id;

    UserQuery(long id) {
        this.id = id;
    }

    @Override
    public RowMapper<User> getRowMapper() {
        return new UserRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(QUERY);
        ps.setLong(1, id);

        return ps;
    }
}
