package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import driver.DriverFactory;
import reports.ExtentManager;
import utils.ConfigReader;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @BeforeSuite
    public void setupReport() {
        ExtentManager.initReports();
    }

    @BeforeMethod
    public void setUp(Method method) {
        // Load config
        ConfigReader.loadProperties();

        // Create driver
        WebDriver webDriver = DriverFactory.createDriver(ConfigReader.get("browser"));
        driver.set(webDriver);

        // Create ExtentTest entry
        ExtentTest test = ExtentManager.getReporter().createTest(method.getName());
        extentTest.set(test);

        // Navigate to base URL
        driver.get().get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // Log test result
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

            // Screenshot on failure
            TakesScreenshot ts = (TakesScreenshot) driver.get();
            String screenshot = ts.getScreenshotAs(OutputType.BASE64);
            extentTest.get().addScreenCaptureFromBase64String(screenshot);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.get().log(Status.PASS, "Test Passed");
        } else {
            extentTest.get().log(Status.SKIP, "Test Skipped");
        }

        // Quit driver
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    @AfterSuite
    public void flushReports() {
        ExtentManager.flushReports();
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
