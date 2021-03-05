package com.example.junitmockitojdoc.repository;

import com.example.junitmockitojdoc.LoginService;
import com.example.junitmockitojdoc.model.User;

import java.util.List;

/**
 * Interface for {@link LoginService} class
 */


public interface ILoginRepo {
    List<User> findAll();
}
