package com.serveeasy.model;

import java.io.Serializable;

/**
 * User: cristian.popovici
 */
public abstract class DomainObject implements Serializable {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
