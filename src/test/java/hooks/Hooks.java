package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void setUp() { DriverFactory.startDriver(); }

    @After
    public void tearDown(Scenario scenario) {
        try {
            WebDriver driver = DriverFactory.getDriver();
            if (scenario.isFailed() && driver instanceof TakesScreenshot) {
                scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                        "image/png", "failure-screenshot");
            }
        } catch (RuntimeException e) {
            System.err.println("Screenshot attachment skipped: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
        }
    }
}
