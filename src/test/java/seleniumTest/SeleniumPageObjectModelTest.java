package seleniumTest;


import SeleniumModels.UniversumShopLoginPageModel;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Selenium Test based on the {@link UniversumShopLoginPageModel} class
 */

public class SeleniumPageObjectModelTest {
    WebDriver driver;
    UniversumShopLoginPageModel universumPageModel;

    @BeforeClass
    public static void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "chromeDriver/chromedriver.exe");
    }

    @Before
    public void Setup() {
        driver = new ChromeDriver();
        universumPageModel = new UniversumShopLoginPageModel(driver);
    }

    /**
     * Testing login form
     */
    @Test
    public void testUserLogin() {
        universumPageModel.navigateToUrl("http://localhost:8080");
        universumPageModel.fillUsername("user");
        universumPageModel.fillPassord("123");
        universumPageModel.clickSubmitButton();

        final String expectedURL = "http://localhost:8080/index";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }

    /**
     * Testing page navigation as a User
     * (Index, Contacts, Products and logout/exit)
     */
    @Test //Index
    public void testPageNavigationAsUserIndex() {
        testUserLogin();

        universumPageModel.navigationIndexClick();
        final String expectedURL = "http://localhost:8080/index";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }

    @Test // Contacts
    public void testPageNavigationAsUserContacts() {
        testUserLogin();

        universumPageModel.navigationContactsClick();
        final String expectedURL1 = "http://localhost:8080/contacts";
        final String result1 = driver.getCurrentUrl();
        assertEquals(expectedURL1, result1);
    }

    @Test // Products
    public void testPageNavigationAsUserProducts() {
        testUserLogin();

        universumPageModel.navigationProductsClick();
        final String expectedURL2 = "http://localhost:8080/products";
        final String result2 = driver.getCurrentUrl();
        assertEquals(expectedURL2, result2);
    }

    @Test //Logout
    public void testPageNavigationAsUserLogout() {
        testUserLogin();

        universumPageModel.navigationLogoutClick();
        final String expectedURL3 = "http://localhost:8080/login?logout";
        final String result3 = driver.getCurrentUrl();
        assertEquals(expectedURL3, result3);
    }
    /**
     *  END of Navigation tests as User
     */

    /**
     * Testing security as a User
     * user should get a generic "Error 403, access forbidden" page
     * for pages such as h2-console and Admin Panel
     */
    @Test //Admin Panel
    public void securityAsUserTest() {
        testUserLogin();

        universumPageModel.navigateToUrl("http://localhost:8080/adminpanel");
        final String expectedMessage = "Whitelabel Error Page";
        final String result = driver.findElement(By.tagName("h1")).getText();
        assertEquals(expectedMessage, result);
    }

    @Test // h2-console
    public void securityAsUserTest1() {
        testUserLogin();

        universumPageModel.navigateToUrl("http://localhost:8080/h2");
        final String expectedMessage = "Whitelabel Error Page";
        final String result = driver.findElement(By.tagName("h1")).getText();
        assertEquals(expectedMessage, result);
    }

    /**
     * Testing login as Admin
     */
    @Test
    public void testAdminLogin() {
        universumPageModel.navigateToUrl("http://localhost:8080");
        universumPageModel.fillUsername("admin");
        universumPageModel.fillPassord("321");
        universumPageModel.clickSubmitButton();
        universumPageModel.navigateToAdminPanel();

        final String expectedURL = "http://localhost:8080/adminpanel";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }

    /**
     * Testing navigation to h2 DB as Admin
     */
    @Test
    public void navigationToH2DataBaseLogin() {
        universumPageModel.navigateToUrl("http://localhost:8080");
        universumPageModel.fillUsername("admin");
        universumPageModel.fillPassord("321");
        universumPageModel.clickSubmitButton();

        universumPageModel.navigateToUrl("http://localhost:8080/h2");
        final String expectedValue = "Login";
        final String result = driver.findElement(By.tagName("th")).getText();
        assertEquals(expectedValue, result);
    }

    @After
    public void after() {
       driver.close();
    }

}
