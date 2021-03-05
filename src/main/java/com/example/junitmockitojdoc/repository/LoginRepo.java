package com.example.junitmockitojdoc.repository;

import com.example.junitmockitojdoc.model.User;

import java.util.Collections;
import java.util.List;

/**
 * Repository class for registered users
 */

public class LoginRepo implements ILoginRepo{


    /**
     * Return all users from the data base.
     * @return not null {@link List<User>}
     */
    public List<User> findAll() {
        return Collections.emptyList();
    }
}
