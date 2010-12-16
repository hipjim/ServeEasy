package com.serveeasy.model.users;

/**
 * User: elvis
 * Date: 11-Nov-2010
 * Time: 19:14:44
 */
public abstract class User {

    private int userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    //@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        
        return true;
    }

    //@Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (isAdmin ? 1 : 0);
        return result;
    }

    //@Override
    public String toString() {
        return "User{" + "\n" +
                "userId=" + userId + "\n" +
                ", fullname='" + fullname + '\'' + "\n" +
                ", username='" + username + '\'' + "\n" +
                ", password='" + getPassword() + '\'' + "\n" +
                ", active=" + isActive() + "\n" +
                ", isAdmin=" + isAdmin() + "\n" +
                '}';
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
}