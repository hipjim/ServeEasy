package com.serveeasy.model.users;

/**
 * handling all details needed by the admin user
 * <p/>
 * User: elvis
 * Date: 11-Nov-2010
 * Time: 19:15:50
 */
final class AdminUser extends User {

    //@Override
    public boolean isActive() {
        return true;
    }

    //@Override
    public boolean isAdmin() {
        return true;
    }

    //@Override
    public boolean isWithPrivileges() {
        return true;
    }
}
