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
public class WorkDay {

    private Map<User, TableCollection> userTables;

    public WorkDay() {
        this.userTables = new HashMap<User, TableCollection>();
    }

    public Set<User> getUsers() {
        return userTables.keySet();
    }

    public void assignUser(User user) {
        this.assignUserToTables(user, new TableCollection());
    }

    public void assignUserToTables(User user, TableCollection tables) {
        this.userTables.put(user, new TableCollection(tables.getTables()));
    }

    public boolean isUserAssignedToTable(User user, Table table) {
        if (this.userTables.keySet().contains(user) &&
                this.userTables.get(user).contains(table)) {
            return true;
        } else {
            return false;
        }
    }

    public TableCollection getTablesForUser(User user) {
        return this.userTables.get(user);
    }

    public Set<User> getUsersForTable(Table table) {
        Set<User> users = new HashSet<User>();

        for (User user : this.userTables.keySet()) {
//            System.out.println("User: "+user);
            TableCollection tables = this.userTables.get(user);
//            System.out.println("tables:"+tables);
//            System.out.println(table);
            if (tables.contains(table)) {
                users.add(user);
            }
        }
        return users;
    }

    public void removeUser(User user) {
        this.userTables.remove(user);
    }


    public void removeTableForUser(User user, Table table) {
        if (isUserAssignedToTable(user, table)) {
            this.userTables.get(user).removeTable(table);
        }
    }

    public void copyUserTablesToUser(User userFrom, User userTo) {
        this.userTables.put(userTo, new TableCollection(this.userTables.get(userFrom).getTables()));
    }

    /**
     * @todo
     */
    public TableCollection viewUnassignedTables() {
        return null;
    }

    public String toString() {
        return this.userTables.toString();
    }
}

