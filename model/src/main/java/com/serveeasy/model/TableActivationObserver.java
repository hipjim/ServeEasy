package com.serveeasy.model;

/**
 * User: cristian.popovici
 * Date: Nov 9, 2010
 * Time: 12:12:59 PM
 */
public interface TableActivationObserver {

    public void onActivation(final Table table);

    public void onDeactivation(final Table table);

}
