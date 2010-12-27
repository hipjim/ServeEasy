package com.serveeasy.dao.api;

import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: cristian.popovici
 * Date: Dec 27, 2010
 * Time: 1:39:08 PM
 */
abstract class PreparedStatementAware {

    final PreparedStatementCreator prepareStatement() {
        return new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                return getPreparedStatement(connection);
            }
        };
    }

    protected abstract PreparedStatement getPreparedStatement(Connection connection)
            throws SQLException;
}
