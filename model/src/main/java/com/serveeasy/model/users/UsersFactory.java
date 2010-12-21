package com.serveeasy.model.users;

import com.serveeasy.model.exceptions.SystemException;

import java.util.List;

/**
 * This is a user factory class.
 * <p/>
 * User: elvis
 * Date: 11-Nov-2010
 * Time: 20:03:05
 */
public class UsersFactory {

    public UsersFactory() {
    }

    public User createUser(UserType usr) {
        User user = null;
        try {
            Class userClass = Class.forName(getUserClassName(usr.getUsertype()));
            user = (User) userClass.newInstance();
        } catch (Exception ex) {
            throw new SystemException("User class unknown");
        }
        return user;
    }

    private String getUserClassName(String usrType) {
        return "com.serveeasy.model.users."+usrType+"User";
    }
}
