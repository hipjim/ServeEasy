package com.serveeasy.model.bar;

/**
 * Possible states enumeration for a {@link Table} object.
 * <p/>
 * Date: Nov 9, 2010
 */
public enum TableStatus {

    ACTIVE(0),
    INACTIVE(1);

    private final int status;

    TableStatus(int status) {
        this.status = status;
    }

    public int status() {
        return status;
    }

}
