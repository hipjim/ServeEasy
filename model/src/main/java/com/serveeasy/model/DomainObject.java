package com.serveeasy.model;

import java.io.Serializable;

/**
 * Abstract type for all domain objects keeping the synthetic pk as long value
 * <p/>
 * User: cristian.popovici
 */
public abstract class DomainObject implements Serializable {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
