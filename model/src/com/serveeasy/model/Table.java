package com.serveeasy.model;

import com.serveeasy.model.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: cristian.popovici
 * Date: Nov 9, 2010
 * Time: 10:20:02 AM
 */
public final class Table implements Serializable {

    private final int capacity;
    private TableStatus tableStats;

    private TableProductInventory inventory;

    private List<TableActivationObserver> activationObserverList;

    public Table(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be at least 1");
        }

        tableStats = TableStatus.INACTIVE;
        this.capacity = capacity;
        activationObserverList = new ArrayList<TableActivationObserver>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void activate() {
        if (isActive()) {
            throw new IllegalStateException("Table is already active");
        }

        tableStats = TableStatus.ACTIVE;

        inventory = new TableProductInventory();

        for (TableActivationObserver observer : activationObserverList) {
            observer.onActivation(this);
        }
    }

    public void deactivate() {
        if (!isActive()) {
            throw new IllegalStateException("Table is already active");
        }

        tableStats = TableStatus.INACTIVE;

        inventory.close();

        for (TableActivationObserver observer : activationObserverList) {
            observer.onDeactivation(this);
        }
    }

    public void addProduct(Product product) {
        inventory.addProduct(product);
    }

    public boolean isActive() {
        return TableStatus.ACTIVE.equals(tableStats);
    }
}
