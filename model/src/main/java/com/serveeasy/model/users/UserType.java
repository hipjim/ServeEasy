package com.serveeasy.model.users;

/**
 * Created by IntelliJ IDEA.
 * User: cristian.popovici
 * Date: Nov 23, 2010
 * Time: 7:20:58 PM
 */
public enum UserType {

    EMPLOYEE("Employee"),
    ADMIN("Admin");


    private String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public String getUsertype() {
        return this.userType;
    }

}
