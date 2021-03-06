package com.serveeasy.model.bar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Holds tables and index them by a unique number assign to it.
 * Mostly a table collection will be available for an area.
 * <p/>
 * Date: Nov 9, 2010
 * Time: 10:28:02 AM
 */
public final class TableCollection {

    private final Set<Table> tableSet;
    private final Map<Integer, Table> tableIndex;

    private TableSequence sequence;

    public TableCollection() {
        sequence = new TableSequence();
        this.tableSet = new HashSet<Table>();
        tableIndex = new HashMap<Integer, Table>();
    }

    public TableCollection(Set<Table> tables) {
        sequence = new TableSequence();
        this.tableSet = tables;
        tableIndex = new HashMap<Integer, Table>();

        for (final Table table : tableSet) {
            tableIndex.put(sequence.getNext(), table);
        }
    }

    public void addTable(final Table table) {
        if (table == null) {
            throw new IllegalArgumentException("Table cannot be null");
        }

        tableIndex.put(sequence.getNext(), table);
        tableSet.add(table);
    }

    public void removeTable(Table table) {
        if (table == null) {
            throw new IllegalArgumentException("Table cannot be null");
        }
        tableSet.remove(table);
    }

    public Table getTable(Integer index) {
        return tableIndex.get(index);
    }

    public Set<Table> getTables() {
        return tableSet;
    }

    public Set<Table> getActiveTables() {
        Set<Table> activeTable = new HashSet<Table>();

        for (Table table : tableSet) {
            if (table.isActive()) {
                activeTable.add(table);
            }
        }

        return activeTable;
    }

    public boolean contains(Table table) {
        if (this.tableSet.contains(table)) {
            return true;
        } else {
            return false;
        }
    }


    private static class TableSequence {

        private Integer counter;

        private TableSequence() {
            this.counter = 0;
        }

        Integer getNext() {
            return ++counter;
        }
    }

    public String toString() {
        String returned = "Tables:\n";
        for (Table t : this.tableSet) {
            returned += t.getTableName() + "\n";
            returned += t + "\n";
        }
        return returned;
    }

}