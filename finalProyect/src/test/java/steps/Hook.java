package steps;

import driver.DriverManager;
import io.cucumber.java.After;

public class Hook {
    @After
    public void quitDriver(){
        DriverManager.quitDriver();
    }
}
