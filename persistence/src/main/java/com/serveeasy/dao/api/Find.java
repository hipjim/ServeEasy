package com.serveeasy.dao.api;

import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 */
public abstract class Find<T> extends PreparedStatementAware {

    public abstract ResultSetExtractor<T> getResultSetExtractor();
}
