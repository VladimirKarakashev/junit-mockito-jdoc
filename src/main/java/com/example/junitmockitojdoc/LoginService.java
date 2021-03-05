package com.example.junitmockitojdoc;

import com.example.junitmockitojdoc.model.User;
import com.example.junitmockitojdoc.repository.ILoginRepo;

import java.util.List;
import java.util.function.Predicate;

/**
 * LoginService class
 */

public class LoginService {

    final ILoginRepo loginRepo;

    public LoginService(ILoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    /**
     * Provides user login functionality.
     *
     * @param userName String representation of UserName.
     *                 Valid not {@code NULL} or empty string.
     * @param password String representation of User's Password.
     *                 Valid not {@code NULL} or empty string.
     * @return String Error message for improperly filled fields.
     */
    public String login(final String userName, final String password) {
        String result = null;
        if (userName == null || password == null) {
            result = "Полетата за име и парола не могат да бъдат празни";
        } else {
            List<User> users = loginRepo.findAll();
            Predicate<? super User> predicate = user ->
                    user.getUserName().equals(userName) &&
                            user.getPassword().equals(password);
            boolean isUserFound = users.stream().anyMatch(predicate);
            result = isUserFound ? "OK" : "Потребител с тези данни не съществува!";
        }
        return result;
    }

    /**
     * @param isAdmin  boolean Determines if a User has Admin role or not.
     * @return String message depending on user role.
     */
    public String roleCheck(boolean isAdmin) {
        String result = null;
        List<User> users = loginRepo.findAll();
        for (User user : users) {
            if (user.isAdmin() == true) {
                result = "Потребителят е администратор";
            } else {
                result = "Потребителят не е администратор";
            }
        }
        return result;
    }
}

