package stepdefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("the user opens the SauceDemo login page")
    public void openLoginPage() {
        loginPage = new LoginPage(DriverFactory.getDriver()).open();
    }

    @When("the user signs in with valid demo credentials")
    public void signInWithDemoCredentials() {
        // Public demo credentials documented by SauceDemo.
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("the products page should be displayed")
    public void verifyProductsPage() {
        Assert.assertEquals(new InventoryPage(DriverFactory.getDriver()).getTitle(),
                "Products", "Products page should appear after successful login.");
    }
}
