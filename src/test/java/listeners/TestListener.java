package listeners;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import factory.DriverFactory;
import io.qameta.allure.Allure;

public class TestListener implements ITestListener {
	
	

    @Override
    public void onTestFailure(ITestResult result) {

        try {

            if (DriverFactory.getDriver() == null) {
                System.out.println(
                        "WebDriver is null. Screenshot cannot be captured."
                );
                return;
            }

            byte[] screenshot =
                    ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    "Failure Screenshot",
                    "image/png",
                    new java.io.ByteArrayInputStream(screenshot),
                    ".png"
            );

            File screenshotFolder = new File("screenshots");

            if (!screenshotFolder.exists()) {
                screenshotFolder.mkdirs();
            }

            File destination = new File( screenshotFolder,result.getMethod().getMethodName() + ".png");
      

            Files.write(destination.toPath(),screenshot);
                    

        } catch (Exception e) {

            System.out.println(
                    "Unable to capture screenshot: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }
}