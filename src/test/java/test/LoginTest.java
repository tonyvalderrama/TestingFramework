package test;

import com.epam.training.tony_valderrama.model.User;
import com.epam.training.tony_valderrama.pages.LoginPage;
import com.epam.training.tony_valderrama.service.UserCreator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends CommonTestStuff {

    final String LOGIN_URL = "https://www.saucedemo.com/inventory.html";

    @Test
    public void validLogin() {
        // Leo datos de usuario de las propiedades
        User user = UserCreator.withCredentialsFromProperty();
        // Creo página de Login y hago login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUser(user.getUsername());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();

        // Veo si el URL es el correcto
        assertThat(loginPage.getURL(), equalTo(LOGIN_URL));
    }

    @Test
    public void noUserName() {
        // Datos del usuario sin nombre
        User user = UserCreator.withEmptyUsername();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUser(user.getUsername());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();

        // Reviso que el mensaje de error sea correcto
        String expectedMessage = "Username is required";
        assertThat(loginPage.getErrorMessage(),equalTo(expectedMessage));
    }

    @Test
    public void noPassword() {
        User user = UserCreator.withEmptyPassword();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUser(user.getUsername());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();
        String expectedMessage = "Password is required";
        assertThat(loginPage.getErrorMessage(),equalTo(expectedMessage));
    }
}
