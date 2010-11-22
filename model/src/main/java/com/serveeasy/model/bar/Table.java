package com.serveeasy.model.bar;

import com.serveeasy.model.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a table.
 * <p/>
 * Date: Nov 9, 2010
 */
public final class Table implements Serializable {

    private final int capacity;
    private TableStatus tableStats;
    private TableProductHolder productHolder;
    private String tableName;

    private final List<TableActivationObserver> activationObserverList;

    public Table(int capacity) {
        tableStats = TableStatus.INACTIVE;
        this.capacity = capacity;
        activationObserverList = new ArrayList<TableActivationObserver>();
    }

    public Table(int capacity, String tableName) {
        tableStats = TableStatus.INACTIVE;
        this.tableName = tableName;
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

        productHolder = new TableProductHolder();

        for (TableActivationObserver observer : activationObserverList) {
            observer.onActivation(this);
        }
    }

    public void deactivate() {
        if (!isActive()) {
            throw new IllegalStateException("Table is already active");
        }

        tableStats = TableStatus.INACTIVE;

        productHolder.close();

        for (TableActivationObserver observer : activationObserverList) {
            observer.onDeactivation(this);
        }
    }

    public void addProduct(Product product) {
        productHolder.addProduct(product);
    }

    public boolean isActive() {
        return TableStatus.ACTIVE.equals(tableStats);
    }

    TableProductHolder getProductHolder() {
        return productHolder;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
