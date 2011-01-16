package com.serveeasy.model.program;

import com.serveeasy.model.BarAware;

import java.sql.Date;


/**
 *
 */
public final class ProgramEntry extends BarAware {

    private final Date date;
    private final long idUser;
    private final long idTable;

    public ProgramEntry(Date date, long idUser, long idTable, long barId) {
        this.date = date;
        this.idUser = idUser;
        this.idTable = idTable;
        this.setBarId(barId);
    }

    public Date getDate() {
        return date;
    }

    public long getIdUser() {
        return idUser;
    }

    public long getIdTable() {
        return idTable;
    }
}
