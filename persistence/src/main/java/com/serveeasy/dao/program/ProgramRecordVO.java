package com.serveeasy.dao.program;

import com.serveeasy.model.BarAware;

import java.sql.Date;


/**
 * todo: Nu ar trebui sa stea aici - ar trebui pus in model.
 * todo: Poate redenumit in ceva de gen ProgramEntry sau ProgramItem.
 * todo: facut immutabil - obiectul sa fie construit prin constructor si nu prin settere. Atributele sa fie finale
 * todo: Nu e recomandat sa folosesti settere cand construiest un obiect, doar cand vrei sa ii schimbi starea
 */
class ProgramRecordVO extends BarAware {

    private Date date;
    private long idUser;
    private long idTable;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdTable() {
        return idTable;
    }

    public void setIdTable(long idTable) {
        this.idTable = idTable;
    }
}
