package com.serveeasy.dao.api;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.util.List;

/**
 * User: cristian.popovici
 */
public abstract class Executor<T> {

    private final JdbcTemplate template;

    protected Executor(final DataSource dataSource) {
        if (dataSource == null) {
            throw new IllegalArgumentException("Data source is null");
        }
        this.template = new JdbcTemplate(dataSource);
    }

    public List<T> executeQuery(final Query<T> command) {
        return template.query(command.prepareStatement(), command.getRowMapper());
    }

    public T executeFind(final Find<T> command) {
        return template.query(command.prepareStatement(), command.getResultSetExtractor());
    }

    public void executeUpdate(final Update command) {
        template.update(command.prepareStatement());
    }
}
