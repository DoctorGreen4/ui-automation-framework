package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    public static WebDriver createDriver() {

        String browser = ConfigReader.testsProperties.browser();

        switch (browser.toLowerCase()) {

            case "chrome":
                return new ChromeDriver();

            case "edge":
                return new EdgeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                throw new RuntimeException("Unknown browser: " + browser);
        }
    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
