package com.serveeasy.model;

/**
 * User: cristian.popovici
 * Date: Nov 9, 2010
 * Time: 10:20:28 AM
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
