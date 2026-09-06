package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import io.qameta.allure.Allure;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();

        String browser = System.getProperty("browser");

        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        Allure.label("browser", browser);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}