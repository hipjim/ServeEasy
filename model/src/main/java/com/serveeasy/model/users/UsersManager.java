package com.serveeasy.model.users;

import java.util.List;

/**
 * This is the a class that handles all users actions regarding adding/editing and deleting.
 * It should make use of the data access object in order to make all modifications required. 
 *
 *
 * @todo - this class needs the dao object in order to make any modification for users
 * //TODO: activate / deactivate / getActiveUsers / getInactiveUsers / getAllUsers / getUser (id, username, fullname)
 * //TODO: add user / edit user / 
 * User: elvis
 * Date: 11-Nov-2010
 * Time: 20:03:05
 */
public class UsersManager {

    private List<User> users;

    public UsersManager() {
        //TODO: here comes the dao object which returns the users, but for now i will use the setUsers method
        //dao.getUsers or something
    }

    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }

//    public boolean activateUser() {
//
//    }
}
