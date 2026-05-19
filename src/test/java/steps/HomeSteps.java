package steps;

import helpers.CustomAssertions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomeSteps {
    private final HomePage homePage;

    public HomeSteps(WebDriver driver) {
        this.homePage = new HomePage(driver);
    }

    @Step("Проверяем соответствие заголовка страницы")
    public HomeSteps verifyTitle(String title) {
        String pageTitle = homePage.getTitle();
        CustomAssertions.assertTrue(pageTitle.equals(title),"Ожидался " + title + " , а был: " + pageTitle);
        return this;
    }
}
