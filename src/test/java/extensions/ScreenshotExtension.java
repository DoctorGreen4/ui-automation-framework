package extensions;

import config.DriverFactory;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class ScreenshotExtension implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        boolean testFailed = extensionContext.getExecutionException().isPresent();

        if (testFailed) {

            var driver = DriverFactory.getDriver();

            if (driver instanceof TakesScreenshot screenshotDriver) {

                byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "Screenshot on Failure",
                        new ByteArrayInputStream(screenshot)
                );
            }
        }
    }
}
