package com.serveeasy.model;

/**
 * User: cristian.popovici
 */
public abstract class BarAware extends DomainObject {

    private long barId;

    public long getBarId() {
        return barId;
    }

    public void setBarId(long barId) {
        this.barId = barId;
    }
}
