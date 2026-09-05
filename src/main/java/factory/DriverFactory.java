package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigReader.get("browser");

        WebDriver webDriver;

        if (browser.equalsIgnoreCase("chrome")) {

            webDriver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            webDriver = new FirefoxDriver();

        } else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }

        webDriver.manage().window().maximize();

        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}