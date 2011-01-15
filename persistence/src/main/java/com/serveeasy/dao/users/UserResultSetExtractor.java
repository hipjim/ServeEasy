package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import com.serveeasy.model.users.UserType;
import com.serveeasy.model.users.UsersFactory;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

class UserResultSetExtractor implements ResultSetExtractor<User> {

    private static final String ACTIVE = "active";
    private static final String FULLNAME = "fullname";
    private static final String ID = "id";
    private static final String BAR_ID = "bar_id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String IS_WITH_PRIVILEGES = "is_with_privileges";
    private static final String IS_ADMIN = "is_admin";

    public User extractData(ResultSet rs) throws SQLException {
        User user;

        if (rs.getBoolean(IS_ADMIN) == true) {
            user = UsersFactory.createUser(UserType.ADMIN);
        } else {
            user = UsersFactory.createUser(UserType.EMPLOYEE);
        }

        user.setActive(rs.getBoolean(ACTIVE));
        user.setFullname(rs.getString(FULLNAME));
        user.setId(rs.getInt(ID));
        user.setUsername(rs.getString(USERNAME));
        user.setPassword(rs.getString(PASSWORD));
        user.setWithPrivileges(rs.getBoolean(IS_WITH_PRIVILEGES));
        user.setBarId(rs.getInt(BAR_ID));

        return user;
    }
}
