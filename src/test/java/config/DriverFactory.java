package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static config.ConfigReader.testsProperties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {

        String browser = testsProperties.browser();

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            if (testsProperties.headless()) {
                options.addArguments("--headless=new");
            }

            return new ChromeDriver(options);
        }

        throw new RuntimeException("Unsupported browser: " + browser);
    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
