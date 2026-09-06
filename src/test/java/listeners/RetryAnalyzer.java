package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;

    private static final int MAX_RETRY_COUNT = 1;

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < MAX_RETRY_COUNT) {

            retryCount++;

            String message =
                    "Retrying test: " + result.getName()
                    + " | Retry attempt: " + retryCount;

 
            Allure.addAttachment(
                    "Retry Information",
                    message
            );

            return true;
        }

        return false;
    }
}