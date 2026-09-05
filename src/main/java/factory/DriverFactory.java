package factory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import utils.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigReader.get("browser");

        WebDriver webDriver;

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("credentials_enable_service", false);

            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("prefs", prefs);

            webDriver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("credentials_enable_service", false);

            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("prefs", prefs);

            webDriver = new EdgeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();

            options.addPreference(
                    "signon.rememberSignons",
                    false
            );

            options.addPreference(
                    "security.password_lifetime",
                    0
            );

            webDriver = new FirefoxDriver(options);

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