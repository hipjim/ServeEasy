package com.serveeasy.model.users;

import com.serveeasy.model.BarAware;

/**
 * User: elvis
 * Date: 11-Nov-2010
 * Time: 19:14:44
 */
public abstract class User extends BarAware {

    private String fullname;
    private String username;
    private String password;
    private boolean active;
    private boolean isAdmin;
    private boolean isWithPrivileges;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isWithPrivileges() {
        return isWithPrivileges;
    }

    public void setWithPrivileges(boolean withPrivileges) {
        isWithPrivileges = withPrivileges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (active != user.active) return false;
        if (isAdmin != user.isAdmin) return false;
        if (isWithPrivileges != user.isWithPrivileges) return false;
        if (fullname != null ? !fullname.equals(user.fullname) : user.fullname != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fullname != null ? fullname.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (isAdmin ? 1 : 0);
        result = 31 * result + (isWithPrivileges ? 1 : 0);
        return result;
    }
}