package com.example.junitmockitojdoc.model;

/**
 * Base User data model. Provides user info.
 */

public class User {
    private String userName;
    private String password;
    private boolean isAdmin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     *
     * @return user role
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     *
     * @param admin determines if a User(false) is an Admin(true)
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
