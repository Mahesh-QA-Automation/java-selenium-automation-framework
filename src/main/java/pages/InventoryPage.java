package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private final By title = By.cssSelector(".title");

    public InventoryPage(WebDriver driver) { super(driver); }

    public String getTitle() { return text(title); }
}
