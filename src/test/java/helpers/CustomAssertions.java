package helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;


public class CustomAssertions {

    @Step("Проверяем что нет ошибки: '{message}'")
    public static void assertTrue(boolean condition, String message) {
        Assertions.assertTrue(condition, message);
    }


    @Step("Останавливаем тест с ошибкой: '{message}'")
    public static void fail(String message) {
        Assertions.fail(message);
    }
}
