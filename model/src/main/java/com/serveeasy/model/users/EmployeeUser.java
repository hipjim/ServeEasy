package com.serveeasy.model.users;

/**
 * User: elvis
 * Date: 11-Nov-2010
 * Time: 20:02:48
 */
class EmployeeUser extends User {


    @Override
    public boolean isAdmin() {
        return false;    
    }
}
