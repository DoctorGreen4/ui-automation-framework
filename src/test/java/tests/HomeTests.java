package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.HomeSteps;

public class HomeTests extends BaseTests{

    @DisplayName("Проверка заголовка страницы")
    @Test()
    public void testTitleHomePage(){
        HomeSteps homeSteps = new HomeSteps(driver);
        homeSteps.verifyTitle("QA Practice | Learn with RV");
    }
}
