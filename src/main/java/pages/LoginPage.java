package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) { super(driver); }

    public LoginPage open() {
        driver.get(ConfigReader.get("base.url", "https://www.saucedemo.com/"));
        return this;
    }

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginButton);
    }
}
