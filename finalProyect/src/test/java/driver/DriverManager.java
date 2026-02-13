package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    private DriverManager() {
        // Constructor privado para evitar la instanciación
    }

    public static WebDriver getDriver(BrowserType browser) {
        if(DRIVER_THREAD_LOCAL.get() == null){
            WebDriver driver = DriverFactory.createDriver(browser);
            DRIVER_THREAD_LOCAL.set(driver);
        }
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void quitDriver() {
        if (DRIVER_THREAD_LOCAL.get() != null) {
            DRIVER_THREAD_LOCAL.get().quit();
            DRIVER_THREAD_LOCAL.remove();
        }
    }
}
