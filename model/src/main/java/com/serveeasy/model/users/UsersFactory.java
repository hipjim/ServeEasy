package com.serveeasy.model.users;

import com.serveeasy.model.exceptions.SystemException;

import java.util.HashMap;
import java.util.Map;

/**
 * User: cristian.popovici
 */
public final class UsersFactory {

    private static final Map<UserType, Class> cache = new HashMap<UserType, Class>(2) {{
        put(UserType.ADMIN, AdminUser.class);
        put(UserType.EMPLOYEE, EmployeeUser.class);
    }};

    private UsersFactory() {
    }

    public static User createUser(final UserType type) {
        final Class userClass = cache.get(type);

        if (userClass == null) {
            throw new IllegalArgumentException("Type " + type + " is not valid");
        }

        try {
            return (User) userClass.newInstance();
        } catch (InstantiationException e) {
            throw new SystemException(e);
        } catch (IllegalAccessException e) {
            throw new SystemException(e);
        }
    }
}
