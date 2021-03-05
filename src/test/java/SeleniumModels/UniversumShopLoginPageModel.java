package SeleniumModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * UniversumShop Page object Model
 */
public class UniversumShopLoginPageModel {

    private WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(className = "btn")
    WebElement submitButton;

    @FindBy(id = "m1")
    WebElement menuIndex;
    @FindBy(id = "m2")
    WebElement menuContacts;
    @FindBy(id = "m3")
    WebElement menuProducts;
    @FindBy(id = "m4")
    WebElement menuLogout;

    @FindBy(id = "ap")
    WebElement adminPanel;


    /**
     * Constructor
     * Initialize instance of UniversumShop Page object Model
     * @param driver a ChromeDriver based on the current Page Object Model Class
     */
    public UniversumShopLoginPageModel (final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToUrl(String value) {
        driver.get(value);
    }

    public void fillUsername(String value) {
        usernameInput.sendKeys(value);
    }

    public void fillPassord(String value) {
        passwordInput.sendKeys(value);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void navigationContactsClick() {
        menuContacts.click();
    }

    public void navigationIndexClick() {
        menuIndex.click();
    }

    public void navigationProductsClick() {
        menuProducts.click();
    }

    public void navigationLogoutClick() {
        menuLogout.click();
    }

    public void navigateToAdminPanel() {
        adminPanel.click();
    }

}

