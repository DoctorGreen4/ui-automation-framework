package helpers;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;


public class CustomSoftAssertions extends SoftAssertions {

    private final SoftAssertions softAssertions = new SoftAssertions();

    @Step("Verify that '{actual}' equals '{expected}'")
    public void assertEquals(String actual, String expected) {
        softAssertions.assertThat(actual)
                .as("Values are not equal")
                .isEqualTo(expected);
    }

    @Step("Verify condition is true")
    public void assertTrue(boolean condition) {
        softAssertions.assertThat(condition)
                .isTrue();
    }

    @Override
    @Step("Проверка всех накопленных soft-assert условий")
    public void assertAll() {
        super.assertAll();
    }
}
