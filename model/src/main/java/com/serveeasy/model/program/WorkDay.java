package com.serveeasy.model.program;

import com.serveeasy.model.bar.Table;
import com.serveeasy.model.bar.TableCollection;
import com.serveeasy.model.users.User;

import java.util.*;

/**
 * User: elvis
 * Date: 14-Nov-2010
 * Time: 15:57:48
 * <p/>
 */
class WorkDay {

    private Map<User, TableCollection> userTables;

    public WorkDay() {
        userTables = new HashMap<User, TableCollection>();
    }

    public Set<User> getUsers() {
        return userTables.keySet();
    }

    public void assignUser(User user) {
        assignUserToTables(user, new TableCollection());
    }

    public void assignUserToTables(User user, TableCollection tables) {
        userTables.put(user, createCopyTableCollection(tables));
    }

     public boolean isUserAssignedToTable(User user, Table table) {
        TableCollection collection = userTables.get(user);
        return collection != null && collection.contains(table);
    }

    public TableCollection getTablesForUser(User user) {
        return userTables.get(user);
    }

    public Set<User> getUsersForTable(Table table) {
        Set<User> users = new HashSet<User>();

        for (User user : userTables.keySet()) {
            TableCollection tables = userTables.get(user);
            if (tables.contains(table)) {
                users.add(user);
            }
        }
        return users;
    }

    public void removeUser(User user) {
        userTables.remove(user);
    }


    public void removeTableForUser(User user, Table table) {
        if (isUserAssignedToTable(user, table)) {
            userTables.get(user).removeTable(table);
        }
    }

    private TableCollection createCopyTableCollection(TableCollection tcFrom) {
        TableCollection copy = new TableCollection();
        Iterator<Table> it = tcFrom.getTables().iterator();
        while (it.hasNext()) {
            copy.addTable(it.next());
        }
        return copy;
    }

    public void copyUserTablesToUser(User userFrom, User userTo) {
        userTables.put(userTo, createCopyTableCollection(userTables.get(userFrom)));
    }

    public String toString() {
        return userTables.toString();
    }
}

