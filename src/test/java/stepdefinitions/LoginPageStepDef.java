package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.epam.training.tony_valderrama.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginPageStepDef {
    private LoginPage loginPage;

    /**
     * Métodos para los scenario definidos en Cucumber (hooks)
     **/
    @Given("I am on the saucedemo login page")
    public void i_am_on_the_saucedemo_login_page() {
        loginPage = new LoginPage();
    }

    @Given("I have entered a empty username and password")
    public void i_have_entered_a_empty_username_and_password() {
        loginPage.login("","");
    }

    @Given("I have entered a valid username and an empty password")
    public void i_have_entered_a_valid_username_and_an_empty_password() {
        loginPage.login("standard_user","");
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.login("standard_user","secret_sauce");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should get an error message Username is required")
    public void i_should_get_an_error_message_username_is_required() {
        String errorText = loginPage.getErrorMessage();
        assertThat(errorText, equalTo("Username is required"));
    }

    @Then("I should get an error message Password is required")
    public void i_should_get_an_error_message_password_is_required() {
        String errorText = loginPage.getErrorMessage();
        assertThat(errorText, equalTo("Password is required"));
    }

    @Then("I should be logged correctly")
    public void loggedIn() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        // Veo que la página haya cambiado a la que ocurre después de hacer login
        assertThat(expectedUrl, equalTo(loginPage.getURL()));
    }
}
