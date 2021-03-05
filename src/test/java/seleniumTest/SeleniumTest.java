package seleniumTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Basic Selenium test class
 */
public class SeleniumTest {
    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "chromeDriver/chromedriver.exe");
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    /**
     * Navigating to the homepage of a WebApp
     * followed by login as User
     */
    @Test
    public void testUserLogin() {
        driver.get("http://localhost:8080");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");
        WebElement submit = driver.findElement(By.className("btn"));
        submit.click();

        final String expectedURL = "http://localhost:8080/index";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }

    @After
    public void after() {
        driver.close();
    }
}
