package steps;

import driver.BrowserType;
import driver.DriverManager;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Given("The user enters on the login page")
    public void userEnterOnPage(){
        logger.info("Initializing WebDriver and opening the login page, Thread: {}", Thread.currentThread().getId());
        driver = DriverManager.getDriver(BrowserType.CHROME);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.open();
    }

    @When("I enter {string} in the username field")
    public void enterUsername(String username){
        logger.info("Entering username: {}, Thread: {}", username, Thread.currentThread().getId());
        loginPage.typeUserName(username);
    }

    @And("I enter {string} in the password field")
    public void enterPassword(String password){
        logger.info("Entering password: {}, Thread: {}", password, Thread.currentThread().getId());
        loginPage.typePassword(password);
    }

    @And("I clear the username field")
    public void clearUsername(){
        logger.info("Clearing username field, Thread: {}", Thread.currentThread().getId());
        loginPage.clearUserName();
    }

    @And("I clear the password field")
    public void clearPassword() {
        logger.info("Clearing password field, Thread: {}", Thread.currentThread().getId());
        loginPage.clearPassword();
    }

    @And("I click the login button")
    public void clickLoginButton(){
        logger.info("Clicking login button, Thread: {}", Thread.currentThread().getId());
        loginPage.clickLogin();
    }

    @Then("I see an error message {string}")
    public void seeErrorMessage(String expectedMessage){
        logger.info("Verifying error message, Thread: {}", Thread.currentThread().getId());
        String actualMessage = loginPage.getErrorMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        DriverManager.quitDriver();
    }

    @Then("I am redirected to the inventory page")
    public void redirectedToInventoryPage(){
        logger.info("Verifying redirection to inventory page, Thread: {}", Thread.currentThread().getId());
        assertTrue(inventoryPage.isPageDisplayed());
    }

    @And("I see the inventory page title {string}")
    public void seeInventoryPageTitle(String expectedTitle){
        logger.info("Verifying inventory page title, Thread: {}", Thread.currentThread().getId());
        assertTrue(inventoryPage.isLogoDisplayed().contains(expectedTitle));
        DriverManager.quitDriver();
    }
}
