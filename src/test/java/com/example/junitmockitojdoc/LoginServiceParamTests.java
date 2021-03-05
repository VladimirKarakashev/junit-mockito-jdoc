package com.example.junitmockitojdoc;

import com.example.junitmockitojdoc.model.User;
import com.example.junitmockitojdoc.repository.ILoginRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 *  Parametrized tests for {@link LoginService} class
 */

@RunWith(Parameterized.class)
public class LoginServiceParamTests {
    @Parameters(name = "{index}: with username={0}, password={1} and expected message={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {null, null, "Полетата за име и парола не могат да бъдат празни"},
                {null, "pass", "Полетата за име и парола не могат да бъдат празни"},
                {"userName", null, "Полетата за име и парола не могат да бъдат празни"},
                {"userName", "pass", "OK"},
                {"userName", "pass1", "Потребител с тези данни не съществува!"},
                {"user", "pass", "Потребител с тези данни не съществува!"}
        });
    }

    @Parameter(0)
    public String username;
    @Parameter(1)
    public String password;
    @Parameter(2)
    public String expectedMessage;

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

    @Test
    public void testLogin() {
        final String result = loginService.login(username, password);
        assertEquals(expectedMessage, result);
    }
}
