package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.epam.training.tony_valderrama.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginPageStepDef {
    private LoginPage loginPage;
    private WebDriver driver;

    /* **
    Metodo que se ejecuta antes de las pruebas e inicializa el WebDriver

    Tengo que crear uno nuevo para cada prueba porque corren en paralelo
     */
    @Before
    public void setup() {
        String browser = System.getProperty("browser", "firefox");
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Métodos para los scenario definidos en Cucumber (hooks)
     **/
    @Given("I am on the saucedemo login page")
    public void i_am_on_the_saucedemo_login_page() {
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered a empty username and password")
    public void i_have_entered_a_empty_username_and_password() {
        loginPage.enterUser("");
        loginPage.enterPassword("");
    }

    @Given("I have entered a valid username and an empty password")
    public void i_have_entered_a_valid_username_and_an_empty_password() {
        loginPage.enterUser("standard_user");
        loginPage.enterPassword("");
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterUser("standard_user");
        loginPage.enterPassword("secret_sauce");
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

    @And("I have entered {string} and {string}")
    public void iHaveEnteredAnd(String userName, String password) {
        loginPage.enterUser(userName);
        loginPage.enterPassword(password);
    }

    @Then("I get the correct {string}")
    public void iGetTheCorrect(String message) {
        assertThat(message,equalTo(loginPage.getErrorMessage()));
    }
}
