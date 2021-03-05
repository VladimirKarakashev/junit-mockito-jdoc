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
 * Parametrized test for {@link LoginService} class
 */

@RunWith(Parameterized.class)
public class UserRoleParamTest {
    @Parameters(name = "{index}: with username={0}, isAdmin={1} and expected message={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Admin1", true, "Потребителят е администратор"},
                {"Ivan", false, "Потребителят не е администратор"},
                {"Petar", false, "Потребителят не е администратор"},
                {"Admin2", true, "Потребителят е администратор"}
        });

    }

    @Parameter(0)
    public String userName;
    @Parameter(1)
    public boolean isAdmin;
    @Parameter(2)
    public String expectedMessage;

    private LoginService loginService;
    private ILoginRepo loginRepo;

    @Before
    public void Setup() {
        loginRepo = mock(ILoginRepo.class);
        User user = new User();
        user.setUserName("userName");
        user.isAdmin();
        List<User> users = Arrays.asList(user);
        doReturn(users).when(loginRepo).findAll();
        loginService = new LoginService(loginRepo);
    }

    @Test
    public void testRoles() {
        final String result = loginService.roleCheck(isAdmin);
        assertEquals(expectedMessage, result);
    }


}
