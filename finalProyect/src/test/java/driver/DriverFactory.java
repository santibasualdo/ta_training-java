package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.nio.file.Paths;


public class DriverFactory {
    // Metodo que crea instancia WebDriver segun el tipo de navegador especificado.
    public static WebDriver createDriver(BrowserType browser) {
        switch (browser) {
            case EDGE:
                System.setProperty(
                        "webdriver.edge.driver",
                        Paths.get(System.getProperty("user.dir"), "drivers", "msedgedriver.exe").toString()
                );
                return new EdgeDriver();
            case CHROME:
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}

