package tests;

import config.ConfigReader;
import config.DriverFactory;
import extensions.ScreenshotExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@ExtendWith(ScreenshotExtension.class)
public abstract class BaseTests {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void before() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.testsProperties.defaultTimeout()));

        driver.manage().deleteAllCookies();
        driver.get(ConfigReader.testsProperties.baseUrl());
    }


    @AfterEach
    public void after() {
        DriverFactory.quitDriver();
    }

}

