package com.serveeasy.model.bar;

public abstract class DomainObject {

    private static final long NOT_SET_BAR_ID = -1;

    private long id;

    private long barId = NOT_SET_BAR_ID;

    public long getBarId() {
        if (barId == NOT_SET_BAR_ID) {
            throw new IllegalStateException("Bar id is not set");
        }

        return barId;
    }

    public void setBarId(int barId) {
        this.barId = barId;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
