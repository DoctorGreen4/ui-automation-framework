package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final String Title = "//h1";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage(){
        driver.findElement(By.id("login")).click();
        return new LoginPage(driver);
    }
}
