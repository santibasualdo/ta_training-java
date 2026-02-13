package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    // Driver
    private final WebDriver driver;
    private WebDriverWait wait;

    //Locators
    private final By userNameInput = By.xpath("//*[@id=\"user-name\"]");
    private final By passwordNameInput = By.xpath("//*[@id=\"password\"]");
    private final By loginButton = By.xpath("//*[@id=\"login-button\"]");
    private final By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage typeUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput))
                .sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordNameInput))
                .sendKeys(password);
        return this;
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .getText();
    }

    public LoginPage clearUserName() {
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);

        return this;
    }

    public LoginPage clearPassword() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordNameInput));
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);

        return this;
    }

    public LoginPage clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton))
                .click();
        return this;
    }
}
