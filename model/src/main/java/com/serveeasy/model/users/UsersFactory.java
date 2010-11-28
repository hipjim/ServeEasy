package com.serveeasy.model.users;

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

    public User createUser(UserType usr) throws Exception {
        Class userClass = Class.forName(this.getUserClassName(usr.getUsertype()));
        return (User) userClass.newInstance();
    }

    private String getUserClassName(String usrType) {
        return "com.serveeasy.model.users."+usrType+"User";
    }
}
