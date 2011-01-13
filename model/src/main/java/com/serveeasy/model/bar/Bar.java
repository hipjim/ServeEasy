package com.serveeasy.model.bar;

/**
 * User: elvis
 * Date: 11-Nov-2010
 * Time: 19:10:54
 *
 * todo: avem nevoie de Bar si de BarDetails?
 */
public class Bar {
    
    private BarDetails barDetails;

    public BarDetails getBarDetails() {
        return barDetails;
    }

    public void setBarDetails(BarDetails barDetails) {
        this.barDetails = barDetails;
    }
}
