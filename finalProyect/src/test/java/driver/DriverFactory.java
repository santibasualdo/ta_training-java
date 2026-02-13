package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverFactory {
    // Metodo que crea instancia WebDriver segun el tipo de navegador especificado.
    public static WebDriver createDriver(BrowserType browser) {
        switch (browser) {
            case EDGE:
                return new EdgeDriver();
            case CHROME:
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}

