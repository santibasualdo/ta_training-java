package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

    private WebDriver driver;
    private final WebDriverWait WAIT;
    private final By LOGO = By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.WAIT = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public boolean isPageDisplayed(){
        return WAIT.until(ExpectedConditions.urlContains("inventory.html"));
    }

    public String isLogoDisplayed() {
        return WAIT.until(driver -> driver.findElement(LOGO)).getText();
    }

}
