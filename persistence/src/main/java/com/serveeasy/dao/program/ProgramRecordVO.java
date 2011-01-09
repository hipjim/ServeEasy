package com.serveeasy.dao.program;

import com.serveeasy.model.bar.Ids;

import java.sql.Date;


/**
 *
 */
class ProgramRecordVO extends Ids{

    private Date date;
    private int idUser;
    private int idTable;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }
}
