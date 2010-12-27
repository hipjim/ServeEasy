package com.serveeasy.model.bar;

/**
 *
 */
public class Ids {
    //this is the id for every object that extends this class
    //like Table or BarDetails etc
    private int id;
    //this is the id for the Bar, it should be the same for all clases
    //extending this class
    private int barId;
    private static boolean isBarIdSet = false;

    public int getBarId() {
        return barId;
    }

    public void setBarId(int barId) {
        if (!isBarIdSet) {
            this.barId = barId;
            isBarIdSet = true;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
