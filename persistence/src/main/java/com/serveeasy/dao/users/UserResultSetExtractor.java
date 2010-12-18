package com.serveeasy.dao.users;

import com.serveeasy.model.users.User;
import com.serveeasy.model.users.UserType;
import com.serveeasy.model.users.UsersFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

class UserResultSetExtractor implements ResultSetExtractor<User> {

    public User extractData(ResultSet rs) throws SQLException {
        UsersFactory uf = new UsersFactory();
        User user = null;

        if (rs.getBoolean("is_admin") == true) {
            user = uf.createUser(UserType.ADMIN);
        } else {
            user = uf.createUser(UserType.EMPLOYEE);
        }

        user.setActive(rs.getBoolean("active"));
        user.setFullname(rs.getString("fullname"));
        user.setUserId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setWithPrivileges(rs.getBoolean("is_with_privileges"));

        return user;
    }
}
