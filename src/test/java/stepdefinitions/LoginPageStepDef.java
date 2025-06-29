package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tony.pages.LoginPage;
import org.tony.services.DriverManager;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginPageStepDef {
    private WebDriver driver;
    private LoginPage loginPage;

    /**
     * Métodos que se ejecutan antes y después de hacer todas las pruebas (Cucumber hook)
     **/
    @Before
    public void setup() {
        driver = DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    /**
     * Métodos para los scenario definidos en Cucumber (hooks)
     **/
    @Given("I am on the saucedemo login page")
    public void i_am_on_the_saucedemo_login_page() {
        loginPage = new LoginPage();
    }

    @Given("I have entered a empty username and password")
    public void i_have_entered_a_empty_username_and_password() {
        loginPage.enterPassword("");
        loginPage.enterUser("");
        loginPage.clickLoginButton();
    }

    @Given("I have entered a valid username and an empty password")
    public void i_have_entered_a_valid_username_and_an_empty_password() {
        loginPage.enterPassword("");
        loginPage.enterUser("standard_user");
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterPassword("secret_sauce");
        loginPage.enterUser("standard_user");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should get an error message Username is required")
    public void i_should_get_an_error_message_username_is_required() {
        String errorText = loginPage.getErrorMessage();
        assertEquals(errorText, "Username is required");
    }

    @Then("I should get an error message Password is required")
    public void i_should_get_an_error_message_password_is_required() {
        String errorText = loginPage.getErrorMessage();
        assertEquals(errorText, "Password is required");
    }

    @Then("I should be logged correctly")
    public void loggedIn() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));

        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
