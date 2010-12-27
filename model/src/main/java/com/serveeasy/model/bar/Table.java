package com.serveeasy.model.bar;

import com.serveeasy.model.product.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a table.
 * <p/>
 * Date: Nov 9, 2010
 */
public final class Table extends Ids implements Serializable {

    private final int capacity;
    private TableStatus tableStats;
    private TableProductHolder productHolder;
    private String tableName;
    private TableCalculator calculator;

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
        calculator = new TableCalculator(this);

        productHolder = new TableProductHolder();

        for (TableActivationObserver observer : activationObserverList) {
            observer.onActivation(this);
        }
    }

    public void deactivate() {
        if (!isActive()) {
            throw new IllegalStateException("Table is already active");
        }

        if (calculator.getPendingMoney().getAmount().compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalStateException("Cannot deactivate table. Money are still pending!");
        }

        calculator = null;

        productHolder.close();
        tableStats = TableStatus.INACTIVE;

        for (TableActivationObserver observer : activationObserverList) {
            observer.onDeactivation(this);
        }
    }

    public TableCalculator getCalucaltor() {
        if (!isActive()) {
            throw new IllegalStateException("Table is not in active state");
        }
        return calculator;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table table = (Table) o;

        if (capacity != table.capacity) return false;
        if (tableName != null ? !tableName.equals(table.tableName) : table.tableName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        return result;
    }

}
