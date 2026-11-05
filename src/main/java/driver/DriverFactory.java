package driver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();
    private DriverFactory() { }

    public static void startDriver() {
        if (DRIVER.get() != null) return;
        String browser = ConfigReader.get("browser", "chrome");
        if ("firefox".equalsIgnoreCase(browser)) {
            DRIVER.set(new FirefoxDriver(new FirefoxOptions()));
        } else if ("chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            DRIVER.set(new ChromeDriver(options));
        } else {
            throw new IllegalArgumentException("Supported browsers: chrome, firefox. Received: " + browser);
        }
    }

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) throw new IllegalStateException("WebDriver has not been started.");
        return DRIVER.get();
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            try { driver.quit(); } finally { DRIVER.remove(); }
        }
    }
}
