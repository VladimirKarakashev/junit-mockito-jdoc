package com.example.junitmockitojdoc;


import com.example.junitmockitojdoc.model.User;
import com.example.junitmockitojdoc.repository.ILoginRepo;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 *  Test class for {@link LoginService}
 */
public class LoginServiceTest {

    private LoginService loginService;
    private ILoginRepo loginRepo;

    @Before
    public void Setup() {
        loginRepo = mock(ILoginRepo.class);
        User user = new User();
        user.setPassword("pass");
        user.setUserName("userName");
        List<User> users = Arrays.asList(user);
        doReturn(users).when(loginRepo).findAll();
        loginService = new LoginService(loginRepo);
    }

    /**
     * test {@link LoginService#login(String, String)} with null entries.
     * Expected message for null values of fields.
     */
    @Test
    public void testLoginWithNullEntries() {

        final String result = loginService.login(null, null);

        assertEquals("Полетата за име и парола не могат да бъдат празни", result);
    }

    /**
     * test {@link LoginService#login(String, String)} with null userName and valid password.
     * Expected message for null values of fields.
     */
    @Test
    public void testLoginWithNullUserName() {

        final String result = loginService.login(null, "pass");

        assertEquals("Полетата за име и парола не могат да бъдат празни", result);
    }

    /**
     * test {@link LoginService#login(String, String)} with null password and valid userName.
     * Expected message for null values of fields.
     */
    @Test
    public void testLoginWithNullPassword() {

        final String result = loginService.login("userName", null);

        assertEquals("Полетата за име и парола не могат да бъдат празни", result);
    }

    /**
     * test {@link LoginService#login(String, String)} with valid entries.
     * Expected "OK" message.
     */
    @Test
    public void testLoginWithValidEntries() {

        final String result = loginService.login("userName", "pass");

        assertEquals("OK", result);
    }

    /**
     * test {@link LoginService#login(String, String)} with non-existing entries.
     * Expected message for non-existing user.
     */
    @Test
    public void testLoginWithNonExistingEntries() {

        final String result = loginService.login("user", "pass1");

        assertEquals("Потребител с тези данни не съществува!", result);
    }

}
