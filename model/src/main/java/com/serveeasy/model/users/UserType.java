package com.serveeasy.model.users;

/**
 * User: cristian.popovici
 */
public enum UserType {

    EMPLOYEE("Employee"),
    ADMIN("Admin");


    private String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public String getUsertype() {
        return userType;
    }

}
